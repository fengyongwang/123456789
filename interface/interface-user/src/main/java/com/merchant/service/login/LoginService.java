package com.merchant.service.login;

import com.merchant.bo.CommonBOResult;
import com.merchant.bo.user.request.UserBORequest;
import com.merchant.bo.user.result.UserBOResult;

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

}
