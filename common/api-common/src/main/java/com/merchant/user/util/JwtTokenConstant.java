package com.merchant.user.util;

/**
 * Description: jwttoken 常量
 *
 * @author Liujy On 2019-04-18.
 * @version 1.0
 * @since JDK 1.8
 */
public class JwtTokenConstant {
    public static final String SECRET = "secret";

    /**
     * 发布者 后面一块去校验
     */
    public static final String ISSUER = "user";


    /**
     * 系统 token失效时长
     * 这里设置为2年失效
     */
    public static final int SYS_TOKEN_EXPIRY_AMOUNT = 730;

    /**
     * cookie相关
     */
    public static final String TOKEN_ID_KEY = "id";
    public static final String TOKEN_PHONE_KEY = "phone";

    public static final String TOKEN_COOKIE = "token";

    /**
     * token失效标识
     * JWT验证失效后直接抛出异常，这里的处理方式是：
     * 1.捕获异常
     * 2.返回值塞入失效标识
     */
    public static final String TOKEN_EXPIRY_KEY = "expiry_key";
    public static final String TOKEN_EXPIRY_VALUE = "token_expiry";
}
