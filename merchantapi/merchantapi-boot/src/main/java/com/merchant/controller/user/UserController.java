package com.merchant.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.merchant.controller.BaseController;
import com.merchant.convert.ConvertManager;
import com.merchant.data.vo.result.CommonResultVO;
import com.merchant.group.Login;
import com.merchant.group.Registered;
import com.merchant.user.service.user.UserService;
import com.merchant.vo.user.request.PhoneVORequest;
import com.merchant.vo.user.request.UserVORequest;
import com.merchant.vo.user.result.UserVOResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
public class UserController extends BaseController {


    @Reference
    private UserService userService;


    @Resource
    private ConvertManager convertManager;

    @ApiOperation(value = "get-sms-code", notes = "获取手机验证码")
    @RequestMapping("/get-sms-code")
    public CommonResultVO getSmsCode(HttpServletRequest request, HttpServletResponse response, @RequestBody @Valid PhoneVORequest smsVORequest) {
        CommonResultVO commonResultVO = new CommonResultVO();


        return commonResultVO;
    }

    @ApiOperation(value = "registered", notes = "注册接口")
    @RequestMapping("/registered")
    public CommonResultVO registered(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) @Validated({Registered.class}) UserVORequest userVORequest) {

        CommonResultVO commonResultVO = new CommonResultVO();


        return commonResultVO;
    }

    @ApiOperation(value = "login", notes = "登录接口")
    @RequestMapping("/login")
    public UserVOResult login(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) @Validated({Login.class}) UserVORequest userVORequest) {
        UserVOResult userVOResult = new UserVOResult();

        return userVOResult;

    }


    @ApiOperation(value = "retrieve-password", notes = "通过手机号找回密码")
    @RequestMapping("retrieve-password")
    public UserVOResult retrievePassword(HttpServletRequest request, HttpServletResponse response, @RequestBody @Valid PhoneVORequest smsVORequest) {
        UserVOResult userVOResult = new UserVOResult();


        return userVOResult;
    }




}
