package com.wyf.user.manager.login.impl;

import com.wyf.bo.CommonBORequest;
import com.wyf.bo.CommonBOResult;
import com.wyf.user.bo.request.LoginBoRequest;
import com.wyf.user.bo.result.LoginBOResult;
import com.wyf.user.constant.UserConfig;
import com.wyf.user.dao.UserDao;
import com.wyf.user.manager.login.LoginManager;
import com.wyf.user.po.request.UserRequest;
import com.wyf.user.po.result.UserResult;
import com.wyf.user.util.ResultUserServiceCodeUtil;
import com.wyf.user.util.TokenUtil;
import com.wyf.util.ResultConstant;
import com.wyf.util.UserUtil;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
@Component
@Log4j
public class LoginManagerImpl implements LoginManager {


    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private UserDao userDao;


    @Override
    public CommonBOResult createSmsCode(String phone) {
        CommonBOResult commonBOResult = new CommonBOResult();
        String code = null;
        try {
            /**
             *校验短信验证码是否到期
             */
            code = (String) redisTemplate.boundValueOps(UserConfig.CODE_GAP_PREFIX + phone).get();
        } catch (Exception e) {
            log.error("redisDao query about smsCode error", e);
            return commonBOResult;
        }

        if (code != null) {
            commonBOResult.setMessage("Verification code is still valid, Please Try again later...");
            return commonBOResult;
        }

        /**
         *生成新的验证码
         */
        String freshCode = UserUtil.createRandomCode(UserConfig.CODELENGTH);
        log.info("create smsCode is: " + freshCode + "when " + new Date());


        /**
         * 将验证码的发送间隔存入redis
         */
        if (!this.insertRedis(UserConfig.CODE_GAP_PREFIX + phone, freshCode, UserConfig.SENDGAP, TimeUnit.MINUTES)) {
            log.warn("insert smsCodeGap to redis error");
            return commonBOResult;
        }

        /**
         * 将验证码存入redis  用于验证码校验
         */
        if (!this.insertRedis(UserConfig.SMS_CODE_PREFIX + phone, freshCode, UserConfig.CODEEFFECTIVETIME, TimeUnit.MINUTES)) {
            log.warn("insert smsCode to redis error");
            return commonBOResult;
        }


        /**
         * 发送短信验证码
         */
        boolean flag = UserUtil.sendMessage(UserConfig.SMS_PREFIX + freshCode);

        if (!flag) {
            commonBOResult.setMessage("smsCode send error, Please Try again...");
            return commonBOResult;
        }

        ResultUserServiceCodeUtil.resultSuccess(commonBOResult);


        return commonBOResult;
    }

    @Override
    public CommonBOResult verifySmsCode(LoginBoRequest request) {
        CommonBOResult commonBOResult = new CommonBOResult();
        String code = (String) redisTemplate.boundValueOps(UserConfig.SMS_CODE_PREFIX + request.getPhone()).get();

        if (StringUtils.isBlank(code)) {
            log.warn("smsCode is empty...");
            commonBOResult.setMessage("smsCode Expired");
            return commonBOResult;
        }

        if(code.equals(request.getCode())){
            ResultUserServiceCodeUtil.resultSuccess(commonBOResult);
        }

        return commonBOResult;
    }

    @Override
    public LoginBOResult systemServiceLogin(String userName, String passWord,Integer identity) {
        LoginBOResult loginBOResult=new LoginBOResult();

        UserRequest userRequest=new UserRequest();
        if(StringUtils.isBlank(userName)||StringUtils.isBlank(passWord)){
            log.warn("userName or passWord is empty...");
            loginBOResult.setMessage("userName or passWord is empty...");
            return loginBOResult;
        }
        userRequest.setUserName(userName);
        userRequest.setPassWord(passWord);
        UserResult userResult=userDao.simpleQueryByRequest(userRequest);

        if(!userResult.isSuccess()||userResult.getValues().size()>0){
            String token=TokenUtil.createToken(userResult);
            if(token!=null){
                loginBOResult.setToken(token);
                ResultUserServiceCodeUtil.resultSuccess(loginBOResult);
            }

        }
        return loginBOResult;
    }

    /**
     * redis  中加入一条数据
     *
     * @param key      key
     * @param msg      消息
     * @param time     时间数量
     * @param timeUnit 时间单位
     * @return
     */
    private boolean insertRedis(String key, String msg, int time, TimeUnit timeUnit) {

        boolean flag = false;
        try {
            redisTemplate.boundValueOps(key).set(msg, time, timeUnit);
            flag = true;
            log.info("insert redis  success");
        } catch (Exception e) {
            log.error("insert redis error", e);
        }
        return flag;
    }

}
