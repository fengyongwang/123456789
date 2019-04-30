package com.wyf.user.dao;

import com.wyf.user.po.data.User;
import com.wyf.user.po.request.UserRequest;
import com.wyf.user.po.result.UserResult;

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
