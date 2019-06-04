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
public class CommodityOrderOfferDetailRequest extends CommonRequestPO {


    /**
     * 订单号
     */
    private List<String> orderUniqueIds;

    /**
     * 优惠描述
     */
    private List<String> cheapDescriptions;

    /**
     * 最大优惠金额
     */
    private String maxCheapMoney;

    /**
     * 最小优惠金额
     */
    private String minCheapMoney;

}
