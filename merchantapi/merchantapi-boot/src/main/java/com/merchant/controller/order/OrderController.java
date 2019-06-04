package com.merchant.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.merchant.controller.BaseController;
import com.merchant.convert.ConvertManager;
import com.merchant.data.vo.result.CommonResultVO;
import com.merchant.order.bo.order.request.OrderBORequest;
import com.merchant.order.service.order.OrderService;
import com.merchant.user.bo.CommonBOResult;
import com.merchant.util.ResultCodeUtil;
import com.merchant.vo.order.param.OrderParam;
import com.merchant.vo.order.request.OrderVORequest;
import com.merchant.vo.order.result.OrderVOResult;
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


    @Reference
    private OrderService orderService;

    @Resource
    private ConvertManager convertManager;

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


    @ApiOperation(value = "create-order", notes = "创建一个订单")
    @RequestMapping("create-order")
    public CommonResultVO createOrder(HttpServletRequest request, HttpServletResponse response, @RequestBody OrderParam orderParam) {
        CommonResultVO commonResultVO = new CommonResultVO();
        OrderBORequest orderBORequest=convertManager.tran(orderParam, OrderBORequest.class);
        CommonBOResult commonBOResult = orderService.createOrder(orderBORequest);

        if (commonBOResult.isSuccess()) {
            ResultCodeUtil.resultSuccess(commonResultVO);
        }

        return commonResultVO;
    }
}
