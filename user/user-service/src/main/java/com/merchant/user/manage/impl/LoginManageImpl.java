package com.merchant.user.manage.impl;

import com.merchant.data.StatusEnum;
import com.merchant.user.bo.CommonBOResult;
import com.merchant.user.bo.ResultConstant;
import com.merchant.user.bo.user.request.UserBORequest;
import com.merchant.user.bo.user.result.UserBOResult;
import com.merchant.user.constant.UserEnum;
import com.merchant.convert.ConvertManager;
import com.merchant.user.dao.UserDao;
import com.merchant.user.manage.MessageManagerDemo;
import com.merchant.user.po.data.User;
import com.merchant.user.po.request.UserRequest;
import com.merchant.user.po.result.UserResult;
import com.merchant.user.manage.LoginManage;
import com.merchant.user.util.ResultUserServiceCodeUtil;
import com.merchant.user.util.UserUtil;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/8
 */
@Component
@Log4j
public class LoginManageImpl implements LoginManage {

    /**
     * 找回商家密码得手机信息内容
     */
    @Value("${user.login.search.password}")
    private String passWordSmsContent;


    /**
     * 替换短信中code得内容
     */
    @Value("${user.code.replaceCode:code}")
    private String replaceCodePassword;

    @Resource
    private UserDao userDao;

    @Resource
    private ConvertManager convertManager;

    @Resource
    private MessageManagerDemo messageManagerDemo;


    @Override
    public CommonBOResult registeredUser(UserBORequest userBORequest) {
        CommonBOResult commonBOResult = new CommonBOResult();
        User user = convertManager.tran(userBORequest, User.class);
        user.setType(UserEnum.MERCHANT.getValue());
        user.setStatus(StatusEnum.EFFECTIVE.getValue());
        UserResult userResult = userDao.insertUser(user);
        if (!userResult.isSuccess()) {
            commonBOResult.setMessage("registered User error ...");
            return commonBOResult;
        }

        /**
         * TODO userInsert 发往kafkademo
         */
        messageManagerDemo.sendMessage(messageManagerDemo.dealInsertBeanToJson(userBORequest));
        ResultUserServiceCodeUtil.resultSuccess(commonBOResult);

        return commonBOResult;
    }

    @Override
    public UserBOResult login(UserBORequest userBORequest) {
        UserBOResult userBOResult = new UserBOResult();
        if (userBORequest == null || StringUtils.isBlank(userBORequest.getUserName()) || StringUtils.isBlank(userBORequest.getPassWord())) {
            log.warn("miss param ...");
            userBOResult.setMessage(ResultConstant.MESSAGE.DEFAULT_MISS_PARAM_MESSAGE);
            return userBOResult;
        }
        UserResult userResult = userDao.simpleQueryByRequest(convertManager.tran(userBORequest, UserRequest.class));
        if (!userResult.isSuccess()) {
            return userBOResult;
        }
        if (userResult.getCount() == 0) {
            log.warn("username or password error ...");
            userBOResult.setMessage("username or password error ...");
            return userBOResult;
        }

        userBOResult = convertManager.tran(userResult.getValue(), UserBOResult.class);


        /**
         * TODO userUpdate 发完kafka demo
         */
        messageManagerDemo.sendMessage(messageManagerDemo.dealUpdateBeanToJson(userBORequest));
        ResultUserServiceCodeUtil.resultSuccess(userBOResult);
        return userBOResult;
    }

    @Override
    public CommonBOResult searchPassword(UserBORequest userBORequest) {

        CommonBOResult commonBOResult = new CommonBOResult();

        UserRequest userRequest = convertManager.tran(userBORequest, UserRequest.class);
        userRequest.setType(UserEnum.MERCHANT.getValue());
        UserResult userResult = userDao.simpleQueryByRequest(userRequest);
        if (!userResult.isSuccess() || userResult.getCount() == 0) {
            log.warn("query password error or password is null in searchPassword ...");
            return commonBOResult;
        }
        if (!this.sendPasswordToPhone(userBORequest.getPhone(), userResult.getValue().getPassWord())) {
            log.warn("send password error in searchPassword ...");
            return commonBOResult;
        }
        ResultUserServiceCodeUtil.resultSuccess(commonBOResult);
        return commonBOResult;
    }

    /**
     * 向用户手机发送验证码
     *
     * @param phone
     * @param password
     * @return
     */
    private Boolean sendPasswordToPhone(String phone, String password) {

        return UserUtil.sendMessage(phone, passWordSmsContent.replaceAll(replaceCodePassword, password));

    }

}
