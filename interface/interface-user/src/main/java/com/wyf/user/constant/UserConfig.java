package com.wyf.user.constant;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
public class UserConfig {

    /**
     * 验证码间隙 前缀
     */
    public static final String CODE_GAP_PREFIX = "CODE_GAP_";

    /**
     * 验证码间隙 前缀
     */
    public static final String SMS_CODE_PREFIX = "APP_SMS_CODE_";




    /**
     * 验证码长度
     */
    public static final int CODELENGTH = 4;


    /**
     * 验证码短信前缀
     */
    public static final String SMS_PREFIX = "您好，您的验证码为：";


    /**
     * 验证码发送时间间隙（一分钟时间内验证码只能发一次）
     */
    public static final int SENDGAP=1;

    /**
     *验证码有效时间，10分钟后自动清除
     */
    public static final int CODEEFFECTIVETIME=10;
}
