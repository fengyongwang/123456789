package com.merchant.order.manage.order.impl;

import com.merchant.order.bo.order.request.OrderBORequest;
import com.merchant.order.manage.order.OrderManager;
import com.merchant.user.bo.CommonBOResult;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/24
 */
@Component
@Log4j
public class OrderManagerImpl implements OrderManager {



    @Override
    public CommonBOResult createOrder(OrderBORequest orderBORequest) {
        return null;
    }
}
