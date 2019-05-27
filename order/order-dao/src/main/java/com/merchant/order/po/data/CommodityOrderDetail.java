package com.merchant.order.po.data;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/27
 */
@Data
public class CommodityOrderDetail implements Serializable {


    private static final long serialVersionUID = -6479860052847485314L;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 商品单价
     */
    private String commodityUnitPrice;

    /**
     * 商品数量
     */
    private String commodityCount;


}
