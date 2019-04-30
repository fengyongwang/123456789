package com.wyf.user.service.login;

import com.wyf.bo.CommonBOResult;
import com.wyf.user.bo.request.LoginBoRequest;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
public interface LoginService {

    /**
     * 获取手机验证码
     * @param request
     * @return
     */
    CommonBOResult getSmsCode(LoginBoRequest request);

    /**
     * 登录
     * @param request
     * @return
     */
    CommonBOResult Login(LoginBoRequest request);



}
