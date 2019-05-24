package com.merchant.order.bo.order.request;

import com.merchant.order.bo.order.param.OrderParamBO;
import com.merchant.user.bo.CommonBORequest;
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
    private List<OrderParamBO> orderParamList;


    /**
     * 原总价
     */
    private String originalTotalPrice;

    /**
     * 实付总价
     */
    private String currentTotalPrice;


}
