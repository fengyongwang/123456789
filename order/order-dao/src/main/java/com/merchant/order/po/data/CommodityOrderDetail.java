package com.merchant.order.po.data;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/6/3
 */
@Data
@Document(collection = "t_yf_commodityOrderDetail")
public class CommodityOrderDetail {

    /**
     * 订单号
     */
    private String orderUniqueId;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 商品单价
     */
    private String commodityUnitPrice;

    /**
     * 商品数量
     */
    private String commodityCount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

}
