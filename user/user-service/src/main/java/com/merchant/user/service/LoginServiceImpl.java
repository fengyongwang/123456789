package com.merchant.user.service;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.user.bo.user.request.UserBORequest;
import com.merchant.user.bo.user.result.UserBOResult;
import com.merchant.user.manage.CheckLegalityManager;
import com.merchant.user.manage.CodeManage;
import com.merchant.user.manage.LoginManage;
import com.merchant.user.manage.MessageManagerDemo;
import com.merchant.user.util.ResultUserServiceCodeUtil;
import com.merchant.user.util.JwtToken;
import com.merchant.user.util.JwtTokenConstant;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/8
 */
@Log4j
@Service
@com.alibaba.dubbo.config.annotation.Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private CodeManage codeManage;

    @Resource
    private LoginManage loginManage;

    @Resource
    private CheckLegalityManager checkLegalityManager;

    @Resource
    private MessageManagerDemo messageManagerDemo;

    @Override
    public CommonBOResult getSmsCode(UserBORequest userBORequest) {
        return this.codeManage.getSmsCode(userBORequest);
    }

    @Override
    public CommonBOResult registeredUser(UserBORequest userBORequest) {
        CommonBOResult result = new CommonBOResult();

        if (!this.checkPassword(userBORequest.getPassWord(), userBORequest.getRepeatPassWord())) {
            return result;
        }

        CommonBOResult commonBOResult = this.codeManage.checkSmsCode(userBORequest);
        if (commonBOResult.isFailed()) {
            log.warn("code is error in loginService ...");
            result.setMessage("code is error");
            return result;
        }

        CommonBOResult nameOrPhoneResult = this.checkLegalityManager.checkNameOrPhone(userBORequest.getUserName(), userBORequest.getPhone());
        if (nameOrPhoneResult.isFailed()) {
            log.error("check userName or phone error ...");
            return nameOrPhoneResult;
        }
        return this.loginManage.registeredUser(userBORequest);
    }

    @Override
    public UserBOResult login(UserBORequest userBORequest) {

        UserBOResult userBOResult = this.loginManage.login(userBORequest);
        if (userBOResult.isSuccess()) {
            log.info("start create token ...");
            userBOResult.setToken(this.createToken(userBOResult));
            ResultUserServiceCodeUtil.resultSuccess(userBOResult);
        } else {
            log.warn("login error in loginService ...");
        }
        return userBOResult;
    }

    @Override
    public CommonBOResult retrievePassword(UserBORequest userBORequest) {

        CommonBOResult result = codeManage.checkSmsCode(userBORequest);
        if (result.isFailed()) {
            log.error("code is error in retrievePassword ...");
            return result;
        }
        return this.loginManage.searchPassword(userBORequest);
    }

    @Override
    public CommonBOResult sendJsonToKafka(UserBORequest userBORequest) {
        CommonBOResult commonBOResult = new CommonBOResult();

//        messageManagerDemo.sendMessage(messageManagerDemo.dealBeanToJson(userBORequest));
        ResultUserServiceCodeUtil.resultSuccess(commonBOResult);
        return commonBOResult;
    }

    /**
     * 生成token
     *
     * @param userBOResult
     * @return
     */
    private String createToken(UserBOResult userBOResult) {
        Map<String, String> claims = new HashMap<>();
        claims.put(JwtTokenConstant.TOKEN_ID_KEY, String.valueOf(userBOResult.getId()));
        claims.put(JwtTokenConstant.TOKEN_PHONE_KEY, userBOResult.getPhone());
        return JwtToken.getToken(claims);
    }

    /**
     * 校验密码与重复密码是否一致
     *
     * @param passWord
     * @param repeatPassWord
     * @return
     */
    private Boolean checkPassword(String passWord, String repeatPassWord) {
        if (StringUtils.isBlank(passWord) || StringUtils.isBlank(repeatPassWord)) {
            log.warn("password or repeatPassWord is null or empty ...");
            return false;
        }
        return passWord.equals(repeatPassWord);
    }

}
