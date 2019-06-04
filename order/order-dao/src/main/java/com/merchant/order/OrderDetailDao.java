package com.merchant.order;

import com.merchant.data.po.result.CommonResultPO;
import com.merchant.order.po.data.CommodityOrderDetail;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/6/3
 */
public interface OrderDetailDao {

    /**
     * 添加一个订单明细
     * @param commodityOrderDetail
     * @return
     */
    CommonResultPO createOrderDetail(CommodityOrderDetail commodityOrderDetail);

}
