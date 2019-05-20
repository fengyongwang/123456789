package com.merchant.user.manage.impl;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.user.bo.ResultConstant;
import com.merchant.user.bo.user.request.UserBORequest;
import com.merchant.user.manage.CodeManage;
import com.merchant.user.util.ResultUserServiceCodeUtil;
import com.merchant.user.util.UserUtil;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/8
 */
@Component
@Log4j
public class CodeManageImpl implements CodeManage {


    /**
     * 验证码一分钟内不能重发得前缀  resend_
     */
    @Value("${user.not.resend.prefix}")
    private String resendPrefix;

    /**
     * 验证码一分钟内不能重发得redis内容   nothing
     */
    @Value("${user.not.resend.content}")
    private String resendContent;

    /**
     * 短信验证码前缀  code_
     */
    @Value("${user.sms.code.prefix}")
    private String smsCodePrefix;

    /**
     * 验证码长度  4
     */
    @Value("${user.code.length}")
    private Integer codeLength;

    /**
     * 验证码过期时间 30min
     */
    @Value("${user.code.timeOut}")
    private Long codeTimeOut;

    /**
     * 验证码发送时间间隔时间  1min
     */
    @Value("${user.not.resend.timeOut}")
    private Long resendTimeOut;


    /**
     * 短信内容
     */
    @Value("${user.sms.code.content}")
    private String smsCodeContent;

    /**
     * 替换短信中code得内容
     */
    @Value("${user.code.replaceCode:code}")
    private String replaceCode;

    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate redisTemplate;

    @Override
    public CommonBOResult getSmsCode(UserBORequest userBORequest) {
        CommonBOResult result = new CommonBOResult();
        log.info("get sms code start ...");
        if (userBORequest == null || StringUtils.isBlank(userBORequest.getPhone())) {
            log.error("miss param ");
            result.setMessage(ResultConstant.MESSAGE.DEFAULT_MISS_PARAM_MESSAGE);
            return result;
        }


        /**
         * 判断是否在一分钟之后发的验证码
         */
        String nothing = redisTemplate.boundValueOps(resendPrefix + userBORequest.getPhone()).get();
        if (nothing != null) {
            log.warn("Please regain the verification code in one minute...");
            result.setMessage("Please regain the verification code in one minute...");
            return result;
        }

        /**
         * 获取短信验证码
         */
        String code = this.createRandomCode(codeLength);
        if (code == null) {
            log.error("create sms_code error");
            result.setMessage("create sms_code error");
            return result;
        }


        /**
         * 将短信验证码发送间隔set进redis数据库，并设置过期时间
         */

        if (!setRedis(resendPrefix + userBORequest.getPhone(), resendContent, resendTimeOut, TimeUnit.MINUTES)) {
            log.error("set resendContent to redis error ...");
            return result;
        }

        /**
         * 将短信验证码set进redis数据库，并设置过期时间
         */
        if (!setRedis(smsCodePrefix + userBORequest.getPhone(), code, codeTimeOut, TimeUnit.MINUTES)) {
            log.error("set code to redis error ...");
            return result;
        }

        /**
         * 发送短信验证码
         */
        if (UserUtil.sendMessage(userBORequest.getPhone(), smsCodeContent.replaceAll(replaceCode, code))) {
            ResultUserServiceCodeUtil.resultSuccess(result);
        }

        return result;
    }

    @Override
    public CommonBOResult checkSmsCode(UserBORequest userBORequest) {
        CommonBOResult result = new CommonBOResult();
        log.info("check sms code start ...");
        if (userBORequest == null || StringUtils.isBlank(userBORequest.getPhone()) || StringUtils.isBlank(userBORequest.getCode())) {
            log.warn("miss param ...");
            result.setMessage("miss param ...");
            return result;
        }


        String code = redisTemplate.boundValueOps(smsCodePrefix + userBORequest.getPhone()).get();
        if (StringUtils.isBlank(code)) {
            log.warn("code is null or empty ...");
            result.setMessage("code is null or empty ...");
            return result;
        }

        if (!code.equals(userBORequest.getCode())) {
            log.warn("check smsCode error ...");
            result.setMessage("code is error ...");
            return result;
        }

        /**
         * 验证成功后删除验证码
         */
        if(redisTemplate.delete(smsCodePrefix + userBORequest.getPhone())){
            ResultUserServiceCodeUtil.resultSuccess(result);
        }

        return result;
    }


    /**
     * 将key-value  set进redis
     *
     * @param key
     * @param value
     * @param time
     * @param timeUnit
     * @return
     */
    private Boolean setRedis(String key, String value, long time, TimeUnit timeUnit) {
        boolean flag = false;

        try {
            redisTemplate.boundValueOps(key).set(value, time, timeUnit);
            flag = true;
        } catch (Exception e) {
            log.error("insert redis error...", e);
        }
        return flag;
    }


    /**
     * 产生随机验证码
     *
     * @param length
     * @return
     */
    private String createRandomCode(int length) {

        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomNum = random.nextInt(10);
            stringBuilder.append(randomNum);
        }
        return stringBuilder.toString();
    }

}
