package com.merchant.user.service.user;

import com.merchant.bo.CommonBOResult;
import com.merchant.user.bo.request.user.UserBORequest;
import com.merchant.user.bo.result.user.UserBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
public interface UserService {

    /**
     * 注册
     * @param request
     * @return
     */
    CommonBOResult registeredUser(UserBORequest request);

    /**
     * 根据条件查
     * @param request
     * @return
     */
    UserBOResult simpleQueryByRequest(UserBORequest request);
}
