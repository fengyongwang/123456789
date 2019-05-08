package com.merchant.user.manage.login;

import com.merchant.bo.CommonBOResult;
import com.merchant.bo.user.request.UserBORequest;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/8
 */
public interface CodeManage {

    /**
     * 获取手机验证码
     * @param userBORequest
     * @return
     */
     CommonBOResult getSmsCode(UserBORequest userBORequest);


    /**
     * 校验手机验证码是否正确
     * @param userBORequest
     * @return
     */
    CommonBOResult checkSmsCode(UserBORequest userBORequest);
}
