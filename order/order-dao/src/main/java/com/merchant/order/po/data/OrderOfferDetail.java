package com.merchant.order.po.data;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/27
 */
@Data
public class OrderOfferDetail implements Serializable {


    private static final long serialVersionUID = 6819946044881028233L;

    /**
     * 优惠描述
     */
    private String cheapDescription;

    /**
     *  优惠金额
     */
    private String cheapMoney;
}
