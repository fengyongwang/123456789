package com.merchant.service.login;

import com.merchant.bo.CommonBOResult;
import com.merchant.bo.user.request.UserBORequest;
import com.merchant.bo.user.result.UserBOResult;
import com.merchant.user.manage.login.CodeManage;
import com.merchant.user.manage.login.LoginManage;
import com.merchant.user.util.ResultUserServiceCodeUtil;
import com.merchant.util.JwtToken;
import com.merchant.util.JwtTokenConstant;
import lombok.extern.log4j.Log4j;
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

    @Override
    public CommonBOResult getSmsCode(UserBORequest userBORequest) {
        return this.codeManage.getSmsCode(userBORequest);
    }

    @Override
    public CommonBOResult registeredUser(UserBORequest userBORequest) {
        CommonBOResult result = new CommonBOResult();
        CommonBOResult commonBOResult = this.codeManage.checkSmsCode(userBORequest);
        if (commonBOResult.isFailed()) {
            log.warn("code is error in loginService ...");
            result.setMessage("code is error");
            return result;
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
}
