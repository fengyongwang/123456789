package com.merchant.user.dao;

import com.merchant.user.po.data.User;
import com.merchant.user.po.request.UserRequest;
import com.merchant.user.po.result.UserResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/30
 */
public interface UserDao {

    /**
     * 根据条件简单查询
     * @param request
     * @return
     */
   UserResult simpleQueryByRequest(UserRequest request);

    /**
     * 添加一个user
     * @param user
     * @return
     */
   UserResult insertUser(User user);


    /**
     * 查询手机号或者用户名是否已经存在
     * @param request
     * @return
     */
   UserResult queryUserByNameOrPhone(UserRequest request);

}
