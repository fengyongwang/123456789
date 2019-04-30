package com.wyf.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wyf.bo.CommonBOResult;
import com.wyf.controller.BaseController;
import com.wyf.convert.ConvertManager;
import com.wyf.data.vo.result.CommonResultVO;
import com.wyf.user.bo.request.LoginBoRequest;
import com.wyf.user.service.login.LoginService;
import com.wyf.util.ResultCodeUtil;
import com.wyf.vo.request.user.LoginVORequest;
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

    @ApiOperation(value = "login",notes = "登录接口")
    @RequestMapping("login")
    public CommonResultVO login(HttpServletRequest request,@RequestBody(required = false) LoginVORequest loginVoRequest){
        CommonResultVO commonResultVO=new CommonResultVO();
        if (loginVoRequest == null ||loginVoRequest.getIdentity()==null) {
            log.warn("request miss must param ...");
            ResultCodeUtil.resultMissParam(commonResultVO);
            return commonResultVO;
        }
        LoginBoRequest loginBoRequest=convertManager.tran(loginVoRequest,LoginBoRequest.class);

        CommonBOResult commonBOResult= loginService.Login(loginBoRequest);

        if(commonBOResult.isSuccess()){
            ResultCodeUtil.resultSuccess(commonResultVO);
        }


        return commonResultVO;
    }


}
