package com.merchant.vo.order.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/7
 */
@Data
@ApiModel
public class OrderVO {

    /**
     * 订单id
     */
    @ApiModelProperty(value = "订单id")
    private Integer id;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    private String userName;

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private Integer commodityId;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String commodityName;
    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号")
    private String uniqueId;

    /**
     * 订单原价
     */
    @ApiModelProperty(value = "订单原价")
    private Double originalPrice;
    /**
     * 订单实付金额
     */
    @ApiModelProperty(value = "订单实付金额")
    private Double currentPrice;
    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态，只显示已付款及以上状态")
    private String orderStatus;

    /**
     * 下单时间
     */
    @ApiModelProperty(value = "下单时间")
    private Date orderTime;

}
