package com.customer.controller.order;

import com.customer.controller.BaseController;
import com.customer.vo.order.request.OrderVORequest;
import com.merchant.data.vo.result.CommonResultVO;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/24
 */
@Log4j
@RestController
@RequestMapping(value = "/customer/order", method = RequestMethod.POST)
@Api(tags = "v1.0.0客户订单相关操作")
public class OrderController extends BaseController {

    /**
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/create-order")
    public CommonResultVO createOrder(HttpServletRequest request, HttpServletResponse response,@RequestBody OrderVORequest orderVORequest) {
        CommonResultVO commonResultVO =new CommonResultVO();

        return commonResultVO;
    }

}
