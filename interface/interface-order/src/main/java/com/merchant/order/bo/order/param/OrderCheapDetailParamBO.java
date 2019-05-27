package com.merchant.order.bo.order.param;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/27
 */
@Data
public class OrderCheapDetailParamBO implements Serializable {
    private static final long serialVersionUID = -3248767218058122350L;

    /**
     * 优惠描述
     */
    private String cheapDescription;

    /**
     *  优惠金额
     */
    private String cheapMoney;

}
