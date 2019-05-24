package com.customer.vo.order.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/24
 */
@Data
@ApiModel
public class OrderParamVO {

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称 必填")
    private String commodityName;

    /**
     * 商品单价
     */
    @ApiModelProperty("商品单价 必填")
    private String commodityUnitPrice;

    /**
     * 商品数量
     */
    @ApiModelProperty("商品数量 必填")
    private String commodityCount;

}
