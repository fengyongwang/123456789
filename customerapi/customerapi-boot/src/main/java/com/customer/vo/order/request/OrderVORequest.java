package com.customer.vo.order.request;

import com.customer.vo.order.param.OrderParamVO;
import com.merchant.data.vo.request.CommonRequestVO;
import io.swagger.annotations.ApiModel;
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
@ApiModel
public class OrderVORequest extends CommonRequestVO {


    /**
     * 订单的商品信息集合
     */
    @ApiModelProperty("订单的商品信息集合")
    private List<OrderParamVO> orderParamList;


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
}
