package com.merchant.user.dao.impl;

import com.merchant.user.dao.UserDao;
import com.merchant.user.po.request.UserRequest;
import com.merchant.user.po.result.UserResult;
import lombok.extern.log4j.Log4j;
import com.merchant.base.BaseDaoTest;
import org.junit.Test;

import javax.annotation.Resource;

@Log4j
public class UserDaoImplTest extends BaseDaoTest {


    @Resource
    private UserDao userDao;


    @Test
    public void simpleQueryByRequest() {
    }

    @Test
    public void insertUser() {
    }

    @Test
    public void queryUserByNameOrPhone() {

        UserRequest userRequest=new UserRequest();
        userRequest.setPhone("18016302686");
        userRequest.setUserName("jack");
        UserResult userResult= userDao.queryUserByNameOrPhone(userRequest);
        System.out.println(userResult.getValue().toString());
    }
}