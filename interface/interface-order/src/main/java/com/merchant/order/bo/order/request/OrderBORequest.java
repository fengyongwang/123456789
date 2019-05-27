package com.merchant.order.bo.order.request;

import com.merchant.order.bo.order.param.OrderCheapDetailParamBO;
import com.merchant.order.bo.order.param.OrderDetailParamBO;
import com.merchant.user.bo.CommonBORequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/24
 */
@Data
public class OrderBORequest extends CommonBORequest {


    /**
     * 订单的商品信息集合
     */
    private List<OrderDetailParamBO> orderDetailParamBO;

    /**
     * 订单优惠得信息集合
     */
    private List<OrderCheapDetailParamBO>orderCheapDetailParamBOList;

    /**
     * 原总价
     */
    private String originalTotalPrice;

    /**
     * 实付总价
     */
    private String currentTotalPrice;

    /**
     * 订单来源类型   mmal 商城
     * {@link com.merchant.order.constant.order}
     */
    private String platform;

    /**
     * 收获地址
     */
    private String rewardAddress;

    /**
     * 收货人姓名
     */
    private String rewardName;

    /**
     * 收获人电话
     */
    private String rewardPhone;
}
