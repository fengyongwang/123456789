package com.merchant.order.po.data;

import com.merchant.data.order.BaseOrder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/24
 */
@Data
@Document(collection = "t_yf_commodity_order")
public class CommodityOrder extends BaseOrder {

    /**
     * 订单号
     */
    private String orderUniqueId;
    /**
     * 订单流水号
     */
    private String orderCode;

    /**
     * 下单时间
     */
    private Date createOrderTime;

    /**
     * 订单状态
     * {@link com.merchant.order.constant.order.OrderConstant}
     */
    private String orderStatus;




}
