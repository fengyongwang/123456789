package com.customer.vo.order.request;

import com.customer.init.Create;
import com.customer.init.Update;
import com.customer.vo.order.param.OrderCheapDetailParamVO;
import com.customer.vo.order.param.OrderDetailParamVO;
import com.merchant.data.vo.request.CommonRequestVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/24
 */
@Data
@ApiModel
public class OrderVORequest extends CommonRequestVO {


    /**
     * 订单的商品信息集合
     */
    @ApiModelProperty("订单的商品信息集合")
    @NotBlank(groups = {Create.class, Update.class})
    private List<OrderDetailParamVO> orderParamList;


    @ApiModelProperty("订单优惠信息集合")
    private List<OrderCheapDetailParamVO>orderCheapDetailParamVOList;

    /**
     * 原总价
     */
    @ApiModelProperty("原总价")
    @NotBlank(groups = {Create.class,Update.class})
    private String originalTotalPrice;

    /**
     * 实付总价
     */
    @ApiModelProperty("实付总价")
    @NotBlank(groups = {Create.class,Update.class})
    private String currentTotalPrice;

    /**
     * 订单来源类型   mmal 商城
     * {@link com.merchant.order.constant.order}
     */
    @ApiModelProperty("订单来源类型 写死值mmal")
    @NotBlank(groups = {Create.class,Update.class})
    private String platform;

    /**
     * 收获地址
     */
    @ApiModelProperty("收获地址 必填")
    @NotBlank(groups = {Create.class,Update.class})
    private String rewardAddress;

    /**
     * 收货人姓名
     */
    @ApiModelProperty("收货人姓名 必填")
    @NotBlank(groups = {Create.class,Update.class})
    private String rewardName;

    /**
     * 收获人电话
     */
    @ApiModelProperty("收货人电话  必填")
    @NotBlank(groups = {Create.class,Update.class})
    private String rewardPhone;
}
