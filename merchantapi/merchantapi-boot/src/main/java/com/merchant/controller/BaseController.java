package com.merchant.controller;

import com.merchant.user.util.JwtTokenConstant;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:  controller 的父类
 *
 * @author wangyf
 * @date 2019/4/29
 */
@Log4j
public abstract class BaseController {


    @ExceptionHandler
    public String handler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.error("api boot  error ... in BaseController",e);

        return e.toString();
    }

    /**
     * 获取商户得userId
     * @param request
     * @return
     */
    protected  Integer getUserId(HttpServletRequest request){
      return (Integer)request.getAttribute(JwtTokenConstant.TOKEN_ID_KEY);

    }

    /**
     * 获取商户得手机号
     * @param request
     * @return
     */
    protected String getPhone(HttpServletRequest request){
        return (String)request.getAttribute(JwtTokenConstant.TOKEN_PHONE_KEY);
    }

}
