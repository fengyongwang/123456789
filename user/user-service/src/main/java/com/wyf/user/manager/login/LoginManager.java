package com.wyf.user.manager.login;

import com.wyf.bo.CommonBORequest;
import com.wyf.bo.CommonBOResult;
import com.wyf.user.bo.request.LoginBoRequest;
import com.wyf.user.bo.result.LoginBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
public interface LoginManager {

    /**
     * 生成验证码存入redis
     * @param phone
     * @return
     */
    CommonBOResult createSmsCode(String phone);

    /**
     * 校验验证码
     * @param request
     * @return
     */
    CommonBOResult verifySmsCode(LoginBoRequest request);


    /**
     * 账号密码登录
     * @param userName
     * @param passWord
     * @param identity
     * @return
     */
    LoginBOResult systemServiceLogin(String userName, String passWord,Integer identity);
}
