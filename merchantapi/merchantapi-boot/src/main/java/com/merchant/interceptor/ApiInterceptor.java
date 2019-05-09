package com.merchant.interceptor;

import com.alibaba.dubbo.config.annotation.Reference;
import com.merchant.bo.token.request.TokenBORequest;
import com.merchant.bo.token.result.TokenBOResult;
import com.merchant.data.vo.result.CommonResultVO;
import com.merchant.service.login.JwtTokenService;
import com.merchant.util.JwtToken;
import com.merchant.util.JwtTokenConstant;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/30
 */
@Log4j
@Component
public class ApiInterceptor extends HandlerInterceptorAdapter {


    @Reference
    private JwtTokenService jwtTokenService;

    @Value("${auth.profiles.active}")
    private String profilesActive;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {


        log.info("customize Interceptor");
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Origin,Content-Type,Accept,token,X-Requested-With");
        response.setHeader("Access-Control-Allow-Credentials", "true");


        if (log.isDebugEnabled()) {
            log.debug("Interceptor started...");
        }

        //本地开发模式
        if (getLocalDav()) {

            processLocalDev(request, response);
            return true;
        }

        /**
         * 校验token
         */
        if(!checkToken(request)){
            log.warn("token error in ApiInterceptor ...");
            return false;
        }


        return super.preHandle(request, response, handler);
    }

    /**
     * 校验token信息
     *
     * @param request
     * @return
     */
    private Boolean checkToken(HttpServletRequest request) {
        /**
         * 获取头得token信息
         */
        String token = request.getHeader("Token");
        log.info(" ----------------token is : " + token);


        return this.tokenTransformResult(token,request);
    }

    /**
     * id 和phone set进request中
     * @param token
     * @param request
     * @return
     */
    private boolean tokenTransformResult(String token, HttpServletRequest request) {
        boolean flag=false;
        TokenBORequest tokenBORequest = new TokenBORequest();
        tokenBORequest.setToken(token);
        TokenBOResult tokenBOResult = jwtTokenService.verifyToken(tokenBORequest);
        if (tokenBOResult.isSuccess()) {
            log.info("id and phone setAttribute starting ...");
            request.setAttribute(JwtTokenConstant.TOKEN_ID_KEY, tokenBOResult.getId());
            request.setAttribute(JwtTokenConstant.TOKEN_PHONE_KEY,tokenBOResult.getPhone());
            flag=true;
        }
        return flag;
    }


    /**
     * 本地开发模块得手机号
     */
    private String phone = "18016302686";
    /**
     * 本地开发模式得userId
     */
    private Integer id = 100;

    /**
     * 本地开发模式处理消息
     *
     * @param request
     * @param response
     */
    private void processLocalDev(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(JwtTokenConstant.TOKEN_ID_KEY, id);
        request.setAttribute(JwtTokenConstant.TOKEN_PHONE_KEY, phone);
        this.mock(response);

    }


    /**
     * 将token信息存入response
     *
     * @param response
     */
    private void mock(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Cookie cookie = new Cookie(JwtTokenConstant.TOKEN_COOKIE, getToken());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 本地开发模式生成token
     *
     * @return
     */
    private String getToken() {
        Map<String, String> claims = new HashMap<>();
        claims.put(JwtTokenConstant.TOKEN_ID_KEY, String.valueOf(id));
        claims.put(JwtTokenConstant.TOKEN_PHONE_KEY, phone);
        return JwtToken.getToken(claims);
    }

    /**
     * 判断是否是本地开发模块
     *
     * @return
     */
    private Boolean getLocalDav() {
        return "local".equals(profilesActive);
    }

}
