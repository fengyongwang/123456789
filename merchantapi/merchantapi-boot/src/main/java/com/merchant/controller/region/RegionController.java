package com.merchant.controller.region;

import com.merchant.controller.BaseController;
import com.merchant.vo.reginon.result.ReginonVOResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/4
 */
@Log4j
@RestController
@RequestMapping(value = "/merchant/region",method = RequestMethod.POST)
@Api(tags = "v1.0.0 查询省市区")
public class RegionController extends BaseController {


//@ApiOperation(value = "query-area",notes = "查询省市区")
//@RequestMapping("/query-area")
//public ReginonVOResult queryArea(HttpServletRequest request, HttpServletResponse response, ReginonVORequest reginonVORequest){
//    ReginonVOResult reginonVOResult=new ReginonVOResult();
//
//
//    return reginonVOResult;
//}

}
