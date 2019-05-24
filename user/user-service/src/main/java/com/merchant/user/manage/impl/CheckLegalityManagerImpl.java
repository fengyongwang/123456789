package com.merchant.user.manage.impl;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.user.dao.UserDao;
import com.merchant.user.manage.CheckLegalityManager;
import com.merchant.user.po.request.UserRequest;
import com.merchant.user.po.result.UserResult;
import com.merchant.user.util.ResultUserServiceCodeUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/21
 */
@Log4j
@Component
public class CheckLegalityManagerImpl implements CheckLegalityManager {

    @Resource
    private UserDao userDao;

    @Override
    public CommonBOResult checkNameOrPhone(String name, String phone) {
        CommonBOResult commonBOResult=new CommonBOResult();
        UserRequest userRequest=new UserRequest();
        userRequest.setUserName(name);
        userRequest.setPhone(phone);
        UserResult userResult= userDao.queryUserByNameOrPhone(userRequest);
        if(!userResult.isSuccess()){
            log.error("query user by name or phone error in checkNameOrPhone ...");
            return commonBOResult;
        }

        if(userResult.getCount()>0){
            log.warn("sorry, this name or phone is Registered ...");
            commonBOResult.setMessage("this name or phone is Registered");
            return commonBOResult;
        }

         ResultUserServiceCodeUtil.resultSuccess(commonBOResult);
        return commonBOResult;
    }
}
