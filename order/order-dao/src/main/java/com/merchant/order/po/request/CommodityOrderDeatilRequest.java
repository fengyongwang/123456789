package com.merchant.order.po.request;

import com.merchant.data.po.request.CommonRequestPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/6/4
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CommodityOrderDeatilRequest extends CommonRequestPO {


    /**
     * 订单号
     */
    private String orderUniqueId;

    /**
     * 订单号集合
     */
    private List<String> orderUniqueIds;

    /**
     * 商品名称集合
     */
    private List<String> commodityNames;

    /**
     * 最大商品单价
     */
    private String maxCommodityUnitPrice;

    /**
     * 最小商品单价
     */
    private String minCommodityUnitPrice;

    /**
     * 最大商品数量
     */
    private String maxCommodityCount;

    /**
     * 最小商品数量
     */
    private String minCommodityCount;

}
