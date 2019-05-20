package com.merchant.user.manage;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.user.bo.user.request.UserBORequest;
import com.merchant.user.bo.user.result.UserBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/8
 */
public interface LoginManage {

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
     * 通过手机号码找回密码
     * @param userBORequest
     * @return
     */
    CommonBOResult  searchPassword(UserBORequest userBORequest);

}
