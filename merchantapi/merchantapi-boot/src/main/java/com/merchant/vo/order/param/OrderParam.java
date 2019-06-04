package com.merchant.vo.order.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/6/3
 */
@Data
@ApiModel
public class OrderParam {


    /**
     * 订单的商品信息集合
     */
    @ApiModelProperty("订单的商品信息集合")
    private List<OrderDetailParam> orderDetailParam;

    /**
     * 订单优惠得信息集合
     */
    @ApiModelProperty("订单优惠得信息集合")
    private List<OrderCheapDetailParam>orderCheapDetailParamList;

    /**
     * 原总价
     */
    @ApiModelProperty("原总价")
    private String originalTotalPrice;

    /**
     * 实付总价
     */
    @ApiModelProperty("实付总价")
    private String currentTotalPrice;

    /**
     * 收获地址
     */
    @ApiModelProperty("收获地址")
    private String rewardAddress;

    /**
     * 收货人姓名
     */
    @ApiModelProperty("收货人姓名")
    private String rewardName;

    /**
     * 收获人电话
     */
    @ApiModelProperty("收获人电话")
    private String rewardPhone;

}
