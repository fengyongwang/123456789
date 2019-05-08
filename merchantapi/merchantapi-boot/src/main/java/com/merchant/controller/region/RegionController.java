package com.merchant.controller.region;

import com.alibaba.dubbo.config.annotation.Reference;
import com.merchant.controller.BaseController;
import com.merchant.convert.ConvertManager;
import com.merchant.shop.bo.request.ReginonBORequest;
import com.merchant.shop.bo.result.ReginonBOResult;
import com.merchant.shop.service.ReginonService;
import com.merchant.util.ResultCodeUtil;
import com.merchant.vo.reginon.request.ReginonVORequest;
import com.merchant.vo.reginon.result.ReginonVOResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
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
 * @date 2019/5/4
 */
@Log4j
@RestController
@RequestMapping(value = "/merchant/region", method = RequestMethod.POST)
@Api(tags = "v1.0.0 查询省市区")
public class RegionController extends BaseController {


    @Reference
    private ReginonService reginonService;

    @Resource
    private ConvertManager convertManager;


    /**
     * 根据父地区得code查询一级子地区列表
     *
     * @param request
     * @param response
     * @param reginonVORequest
     * @return
     */
    @ApiOperation(value = "query-area", notes = "查询省市区")
    @RequestMapping("/query-area")
    public ReginonVOResult queryArea(HttpServletRequest request, HttpServletResponse response, @RequestBody @Valid ReginonVORequest reginonVORequest) {
        ReginonVOResult reginonVOResult = new ReginonVOResult();
        log.info("start query-area in Reginoncontroller...");
        ReginonBORequest reginonBORequest = convertManager.tran(reginonVORequest, ReginonBORequest.class);

        ReginonBOResult reginonBOResult = reginonService.queryReginonByRequest(reginonBORequest);
        if (reginonBOResult.isSuccess()) {
            log.info("reginon Service queryReginon success...");
            reginonVOResult = convertManager.tran(reginonBOResult, ReginonVOResult.class);
            ResultCodeUtil.resultSuccess(reginonVOResult);
        }


        return reginonVOResult;
    }

}
