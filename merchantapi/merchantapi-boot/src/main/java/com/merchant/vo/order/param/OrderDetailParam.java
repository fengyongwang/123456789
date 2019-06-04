package com.merchant.vo.order.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/6/3
 */
@Data
@ApiModel
public class OrderDetailParam implements Serializable {

    private static final long serialVersionUID = 675036202787186064L;
    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String commodityName;

    /**
     * 商品单价
     */
    @ApiModelProperty("商品单价")
    private String commodityUnitPrice;

    /**
     * 商品数量
     */
    @ApiModelProperty("商品数量")
    private String commodityCount;
}
