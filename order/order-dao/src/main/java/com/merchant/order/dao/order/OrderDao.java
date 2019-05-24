package com.merchant.order.dao.order;

import com.merchant.data.po.result.CommonResultPO;
import com.merchant.order.po.data.CommodityOrder;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/24
 */
public interface OrderDao {

    /**
     * 增加一个订单
     * @param commodityOrder
     * @return
     */
    CommonResultPO createOrder(CommodityOrder commodityOrder);

}
