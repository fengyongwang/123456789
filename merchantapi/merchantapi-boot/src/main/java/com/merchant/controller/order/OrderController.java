package com.merchant.controller.order;

import com.merchant.controller.BaseController;
import com.merchant.data.vo.result.CommonResultVO;
import com.merchant.vo.order.request.OrderVORequest;
import com.merchant.vo.order.result.OrderVOResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/7
 */
@Log4j
@RestController
@RequestMapping(value = "/merchant/order", method = RequestMethod.POST)
@Api(tags = "v1.0.0商铺订单相关操作")
public class OrderController extends BaseController {

    @ApiOperation(value = "query-order", notes = "商家查询该商铺得订单查询订单")
    @RequestMapping("query-order")
    public OrderVOResult queryOrderByShopId(HttpServletRequest request, HttpServletResponse response, @RequestBody OrderVORequest orderRequest) {
        OrderVOResult result = new OrderVOResult();
        return result;
    }

    @ApiOperation(value = "update-order-status", notes = "修改订单状态")
    @RequestMapping("update-order-status")
    public CommonResultVO updateOrderStatusByShopId(HttpServletRequest request, HttpServletResponse response, @RequestBody OrderVORequest orderRequest) {
        CommonResultVO commonResultVO = new CommonResultVO();
        return commonResultVO;
    }

}
