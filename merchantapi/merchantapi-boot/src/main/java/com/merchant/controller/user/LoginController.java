package com.merchant.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.merchant.user.bo.CommonBOResult;
import com.merchant.user.bo.user.request.UserBORequest;
import com.merchant.user.bo.user.result.UserBOResult;
import com.merchant.controller.BaseController;
import com.merchant.convert.ConvertManager;
import com.merchant.data.vo.result.CommonResultVO;
import com.merchant.group.Login;
import com.merchant.group.Registered;
import com.merchant.user.service.LoginService;
import com.merchant.user.util.JwtTokenConstant;
import com.merchant.user.util.ResultCodeUtil;
import com.merchant.vo.user.request.PhoneVORequest;
import com.merchant.vo.user.request.UserVORequest;
import com.merchant.vo.user.result.UserVOResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/1
 */
@Log4j
@RestController
@RequestMapping(value = "/merchant/user", method = RequestMethod.POST)
@Api(tags = "V1.0.0 商家商户相关操作")
public class LoginController extends BaseController {


    @Reference
    private LoginService loginService;


    @Resource
    private ConvertManager convertManager;


    /**
     * 获取手机验证码
     * @param request
     * @param response
     * @param smsVORequest
     * @return
     */
    @ApiOperation(value = "get-sms-code", notes = "获取手机验证码")
    @RequestMapping("/get-sms-code")
    public CommonResultVO getSmsCode(HttpServletRequest request, HttpServletResponse response, @RequestBody @Valid PhoneVORequest smsVORequest) {
        CommonResultVO commonResultVO = new CommonResultVO();
        log.info("get sms code in LoginController ...");
        CommonBOResult commonBOResult = loginService.getSmsCode(convertManager.tran(smsVORequest, UserBORequest.class));
        if (commonBOResult.isSuccess()) {
            ResultCodeUtil.resultSuccess(commonResultVO);
        }
        return commonResultVO;
    }

    /**
     * 店家注册接口
     * @param request
     * @param response
     * @param userVORequest
     * @return
     */
    @ApiOperation(value = "registered", notes = "店家注册接口")
    @RequestMapping("/registered")
    public CommonResultVO registered(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) @Validated({Registered.class}) UserVORequest userVORequest) {

        CommonResultVO commonResultVO = new CommonResultVO();
        log.info("registered start in LoginController ...");
        CommonBOResult commonBOResult = loginService.registeredUser(convertManager.tran(userVORequest, UserBORequest.class));
        if (commonBOResult.isFailed()) {
            log.error("registered user error in LoginController...");
            return commonResultVO;
        }
        ResultCodeUtil.resultSuccess(commonResultVO);
        return commonResultVO;
    }

    /**
     * 店家登录接口
     * @param request
     * @param response
     * @param userVORequest
     * @return
     */
    @ApiOperation(value = "login", notes = "店家登录接口")
    @RequestMapping("/login")
    public UserVOResult login(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) @Validated({Login.class}) UserVORequest userVORequest) {
        UserVOResult userVOResult = new UserVOResult();
        log.info("login start in LoginController ...");
        /**
         * 清除cookie
         */
        this.removeRequestCookies(request,response);

        UserBOResult userBOResult = loginService.login(convertManager.tran(userVORequest, UserBORequest.class));
        if (userBOResult.isFailed()) {
            log.error("login error in LoginController ...");
            return userVOResult;
        }
        userVOResult = convertManager.tran(userBOResult, UserVOResult.class);
        /**
         * 将token塞进cookie
         */
        this.responseCookie(response,userVOResult.getToken());

        ResultCodeUtil.resultSuccess(userVOResult);
        return userVOResult;

    }

    /**
     * 店家通过手机号码找回账户密码
     * @param request
     * @param response
     * @param smsVORequest
     * @return
     */
    @ApiOperation(value = "retrieve-password", notes = "通过手机号找回密码")
    @RequestMapping("retrieve-password")
    public CommonResultVO retrievePassword(HttpServletRequest request, HttpServletResponse response, @RequestBody @Valid PhoneVORequest smsVORequest) {
        CommonResultVO commonResultVO = new CommonResultVO();

        if(StringUtils.isBlank(smsVORequest.getCode())){
            log.error("miss param in retrievePassword ...");
            return commonResultVO;
        }

        CommonBOResult commonBOResult=loginService.retrievePassword(convertManager.tran(smsVORequest,UserBORequest.class));
        if(commonBOResult.isFailed()){
            log.error("retrievePassword by phone error in loginController ...");
            return commonResultVO;
        }

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
