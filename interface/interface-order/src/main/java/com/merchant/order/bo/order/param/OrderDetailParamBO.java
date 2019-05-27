package com.merchant.order.bo.order.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/24
 */
@Data
public class OrderDetailParamBO implements Serializable {
    private static final long serialVersionUID = 6447899575723235883L;

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
