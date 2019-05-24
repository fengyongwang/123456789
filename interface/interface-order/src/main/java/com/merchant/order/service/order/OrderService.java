package com.merchant.order.service.order;

import com.merchant.order.bo.order.request.OrderBORequest;
import com.merchant.user.bo.CommonBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/24
 */
public interface OrderService {

    /**
     * 创建一个订单
     * @param orderBORequest
     * @return
     */
    CommonBOResult createOrder(OrderBORequest orderBORequest);

}
