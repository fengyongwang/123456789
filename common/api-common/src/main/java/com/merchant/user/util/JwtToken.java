package com.merchant.user.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: JWT token工具类
 *
 * @author wangyf
 * @date 2019/4/17
 */
public class JwtToken {
    /**
     * 生成token的操作
     *
     * @param claims
     * @return
     */
    public static String getToken(Map<String, String> claims) {
        try {
            //签名算法
            Algorithm algorithm = Algorithm.HMAC256(JwtTokenConstant.SECRET);
            //生成JWT的时间
            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);
            JWTCreator.Builder builder = JWT.create().withIssuer(JwtTokenConstant.ISSUER);
            // JWT设置token创建和失效时间DateUtils.addDays(now, 1)
            builder.withIssuedAt(now).withExpiresAt(DateUtils.addDays(now, JwtTokenConstant.SYS_TOKEN_EXPIRY_AMOUNT));
            //相当于将claims存储在token中
            claims.forEach(builder::withClaim);
            return builder.sign(algorithm);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public static Map<String, String> verifyToken(String token) {
        Algorithm algorithm;
        try {
            algorithm = Algorithm.HMAC256(JwtTokenConstant.SECRET);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        JWTVerifier verifier = JWT.require(algorithm).withIssuer(JwtTokenConstant.ISSUER).build();
        Map<String, String> resultMap = new HashMap<>(8);
        try {
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> map = jwt.getClaims();
            map.forEach((k, v) -> resultMap.put(k, v.asString()));
        } catch (TokenExpiredException | JWTDecodeException e) {
            // JWT内部会判断失效时间，这里会抛出异常
            resultMap.put(JwtTokenConstant.TOKEN_EXPIRY_KEY,JwtTokenConstant.TOKEN_EXPIRY_VALUE);
        }
        return resultMap;
    }



}
