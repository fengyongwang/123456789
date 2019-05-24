package com.merchant.user.service;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.user.bo.user.request.UserBORequest;
import com.merchant.user.bo.user.result.UserBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/8
 */
public interface LoginService {

    /**
     * 获取手机验证码
     *
     * @param userBORequest
     * @return
     */
    CommonBOResult getSmsCode(UserBORequest userBORequest);

    /**
     * 店家注册
     * @param userBORequest
     * @return
     */
    CommonBOResult registeredUser(UserBORequest userBORequest);

    /**
     * 店家登录
     * @param userBORequest
     * @return
     */
    UserBOResult login(UserBORequest userBORequest);

    /**
     * 通过手机号找回密码
     * @param userBORequest
     * @return
     */
    CommonBOResult retrievePassword(UserBORequest userBORequest);

    /**
     * 发送数据到kafka  demo
     * @param userBORequest
     * @return
     */
    CommonBOResult sendJsonToKafka(UserBORequest userBORequest);

}
