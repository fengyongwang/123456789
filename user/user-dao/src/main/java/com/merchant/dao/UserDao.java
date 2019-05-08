package com.merchant.dao;

import com.merchant.po.data.User;
import com.merchant.po.request.UserRequest;
import com.merchant.po.result.UserResult;

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
}
