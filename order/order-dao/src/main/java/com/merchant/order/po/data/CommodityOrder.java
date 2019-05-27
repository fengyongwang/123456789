package com.merchant.order.po.data;

import com.merchant.data.order.BaseOrder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/24
 */
@Data
@Document(collection = "t_yf_commodity_order")
public class CommodityOrder extends BaseOrder {

    /**
     * 订单明细
     */
    private List<CommodityOrderDetail> commodityOrderDetailList;

    /**
     * 优惠明细
     */
    private List<OrderOfferDetail>orderOfferDetails;

}
