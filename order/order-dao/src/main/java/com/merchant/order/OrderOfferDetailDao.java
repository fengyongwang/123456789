package com.merchant.order;

import com.merchant.data.po.result.CommonResultPO;
import com.merchant.order.po.data.CommodityOrderOfferDetail;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/6/3
 */
public interface OrderOfferDetailDao {

    /**
     * 添加一个订单优惠明细
     * @param commodityOrderOfferDetail
     * @return
     */
    CommonResultPO createOrderOfferDetail(CommodityOrderOfferDetail commodityOrderOfferDetail);

}
