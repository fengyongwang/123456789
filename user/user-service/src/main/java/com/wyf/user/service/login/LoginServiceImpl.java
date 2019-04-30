package com.wyf.user.service.login;

import com.wyf.bo.CommonBOResult;
import com.wyf.convert.ConvertManager;
import com.wyf.user.bo.request.LoginBoRequest;
import com.wyf.user.bo.result.LoginBOResult;
import com.wyf.user.constant.UserEnum;
import com.wyf.user.dao.UserDao;
import com.wyf.user.manager.login.LoginManager;
import com.wyf.user.po.data.User;
import com.wyf.user.po.request.UserRequest;
import com.wyf.user.po.result.UserResult;
import com.wyf.user.util.ResultUserServiceCodeUtil;
import com.wyf.user.util.TokenUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
@Log4j
@Service
@com.alibaba.dubbo.config.annotation.Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private ConvertManager convertManager;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private UserDao userDao;

    @Resource
    private LoginManager loginManager;

    @Override
    public CommonBOResult getSmsCode(LoginBoRequest request) {
        CommonBOResult commonBOResult = new CommonBOResult();

        commonBOResult = loginManager.createSmsCode(request.getPhone());


        return commonBOResult;
    }

    @Override
    public LoginBOResult Login(LoginBoRequest request) {
        LoginBOResult loginBOResult = new LoginBOResult();

        if (request.getIdentity() == UserEnum.CUSTOMER.getValue()||request.getIdentity() == UserEnum.MERCHANT.getValue()) {
            /**
             *顾客登录
             */
            CommonBOResult result = loginManager.verifySmsCode(request);

            if (result.isFailed()) {
                log.warn("customer login smsCode is error...");
                loginBOResult.setMessage("customer login smsCode is error...");
                return loginBOResult;
            }

            UserRequest userRequest = convertManager.tran(request,UserRequest.class);
            UserResult userResult= userDao.simpleQueryByRequest(userRequest);
            if(!userResult.isSuccess()){
                ResultUserServiceCodeUtil.resultError(loginBOResult);
                return loginBOResult;
            }

                   String token= TokenUtil.createToken(userResult);
            if(token!=null) {
                loginBOResult.setToken(token);
                ResultUserServiceCodeUtil.resultSuccess(loginBOResult);
            }
        }else if (request.getIdentity() == UserEnum.SYSTEMSERVICE.getValue()) {

            /**
             * 系统后台服务者   账号密码登录
             */
            loginBOResult = loginManager.systemServiceLogin(request.getUserName(), request.getPassWord(), request.getIdentity());


        }
        return loginBOResult;
    }


}
