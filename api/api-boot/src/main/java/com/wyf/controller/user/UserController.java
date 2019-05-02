package com.wyf.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wyf.bo.CommonBOResult;
import com.wyf.controller.BaseController;
import com.wyf.convert.ConvertManager;
import com.wyf.data.vo.result.CommonResultVO;
import com.wyf.user.bo.request.user.UserBORequest;
import com.wyf.user.bo.result.user.UserBOResult;
import com.wyf.user.service.user.UserService;
import com.wyf.util.ResultCodeUtil;
import com.wyf.util.ResultConstant;
import com.wyf.vo.user.request.UserVORequest;
import com.wyf.vo.user.result.UserVOResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
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
@RequestMapping(value = "mall/common", method = RequestMethod.POST)
@Api(tags = "V1.0.0 用户相关操作")
public class UserController extends BaseController {


    @Reference
    private UserService userService;


    @Resource
    private ConvertManager convertManager;

    @ApiOperation(value = "toRegistered", notes = "去注册接口")
    @RequestMapping("/toRegistered")
    public CommonResultVO toRegistered(HttpServletRequest request, HttpServletResponse response) {
        CommonResultVO commonResultVO = new CommonResultVO();

        /**
         * 设置相应类型,告诉浏览器输出的内容为图片
         */
        response.setContentType("image/jpeg");
        /**
         * 设置响应头信息，告诉浏览器不要缓存此内容
         */
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        /**
         * TODO 绘制图片验证码，并将验证码存入redis 便于校验
         */
        ResultCodeUtil.resultSuccess(commonResultVO);
        return commonResultVO;
    }

    @ApiOperation(value = "registered", notes = "注册接口")
    @RequestMapping("/registered")
    public CommonResultVO registered(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) @Valid UserVORequest userVORequest) {

        CommonResultVO commonResultVO = new CommonResultVO();

        if (userVORequest == null || StringUtils.isBlank(userVORequest.getPhone())) {
            log.warn("request miss must param ...");
            commonResultVO.setMessage(ResultConstant.MESSAGE.DEFAULT_MISS_PARAM_MESSAGE);
            return commonResultVO;
        }


        UserBORequest userBORequest = convertManager.tran(userVORequest, UserBORequest.class);

        CommonBOResult commonBOResult = userService.registeredUser(userBORequest);

        if (commonBOResult.isSuccess()) {
            log.info("registered success");
            ResultCodeUtil.resultSuccess(commonResultVO);
        }

        return commonResultVO;
    }

    @ApiOperation(value = "login", notes = "登录接口")
    @RequestMapping("/login")
    public UserVOResult login(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) @Valid UserVORequest userVORequest) {
        UserVOResult userVOResult =new UserVOResult();
        UserBORequest userBORequest=convertManager.tran(userVORequest,UserBORequest.class);
        UserBOResult userBOResult=userService.simpleQueryByRequest(userBORequest);
        if(userBOResult.isSuccess()){
            userVOResult=convertManager.tran(userBOResult,UserVOResult.class);
        }
        return userVOResult;

    }


/**
 * 通过手机号找回密码
 */

/**
 * 重置密码
 */

}
