package com.wyf.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wyf.bo.CommonBOResult;
import com.wyf.controller.BaseController;
import com.wyf.convert.ConvertManager;
import com.wyf.data.vo.result.CommonResultVO;
import com.wyf.user.bo.request.LoginBoRequest;
import com.wyf.user.bo.result.LoginBOResult;
import com.wyf.user.service.login.LoginService;
import com.wyf.util.JwtTokenConstant;
import com.wyf.util.ResultCodeUtil;
import com.wyf.vo.request.user.LoginVORequest;
import com.wyf.vo.result.user.LoginVOResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
@Log4j
@RestController
@RequestMapping(value = "/api/user", method = RequestMethod.POST)
@Api(tags = "v1.0.0 用户登陆相关操作")
public class LoginController extends BaseController {


    @Resource
    private ConvertManager convertManager;

    @Reference
    private LoginService loginService;


    @ApiOperation(value = "get-sms-code", notes = "获取手机验证码接口")
    @RequestMapping(value = "get-sms-code")
    public CommonResultVO getSmsCode(HttpServletRequest request, @RequestBody(required = false) LoginVORequest loginVoRequest) {
        CommonResultVO commonResultVO = new CommonResultVO();
        if (loginVoRequest == null || StringUtils.isBlank(loginVoRequest.getPhone())) {
            log.warn("request miss must param ...");
            ResultCodeUtil.resultMissParam(commonResultVO);
            return commonResultVO;
        }

        LoginBoRequest loginBoRequest = convertManager.tran(loginVoRequest, LoginBoRequest.class);


        CommonBOResult commonBOResult = loginService.getSmsCode(loginBoRequest);

        if (commonBOResult.isSuccess()) {
            ResultCodeUtil.resultSuccess(commonResultVO);
        }

        return commonResultVO;
    }

    @ApiOperation(value = "login", notes = "登录接口")
    @RequestMapping("login")
    public LoginVOResult login(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) LoginVORequest loginVoRequest) {
        LoginVOResult loginVOResult = new LoginVOResult();
        if (loginVoRequest == null || loginVoRequest.getIdentity() == null) {
            log.warn("request miss must param ...");
            ResultCodeUtil.resultMissParam(loginVOResult);
            return loginVOResult;
        }
        /**
         * 清楚cookie
         */
        this.removeRequestCookies(request, response);
        LoginBoRequest loginBoRequest = convertManager.tran(loginVoRequest, LoginBoRequest.class);

        LoginBOResult loginBOResult = loginService.Login(loginBoRequest);


        if (loginBOResult.isSuccess()) {
            /**
             * token 存入cookie
             */
            this.responseCookie(response, loginBOResult.getToken());
            loginVOResult = convertManager.tran(loginBOResult, LoginVOResult.class);
            ResultCodeUtil.resultSuccess(loginVOResult);
        }


        return loginVOResult;
    }


    @ApiOperation(value = "login", notes = "登录接口")
    @RequestMapping("login")
    public CommonResultVO logout(HttpServletRequest request, HttpServletResponse response) {
        CommonResultVO commonResultVO = new CommonResultVO();

        this.removeRequestCookies(request, response);
        ResultCodeUtil.resultSuccess(commonResultVO);
        return commonResultVO;
    }

    /**
     * 创建cookie
     *
     * @param response
     * @param token
     */
    private void responseCookie(HttpServletResponse response, String token) {
        // 跨域是否需要设置
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Cookie cookie = new Cookie(JwtTokenConstant.TOKEN_COOKIE, token);
        cookie.setPath("/");
        response.addCookie(cookie);
    }


    /**
     * 清除cookie
     *
     * @param request
     */
    private void removeRequestCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie token = WebUtils.getCookie(request, JwtTokenConstant.TOKEN_COOKIE);
        if (token != null) {
            token.setMaxAge(0);
            response.addCookie(token);
        }
    }

}
