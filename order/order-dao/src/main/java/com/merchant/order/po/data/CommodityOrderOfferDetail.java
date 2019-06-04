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
@Document(collection = "t_yf_CommodityOrderOfferDetail")
public class CommodityOrderOfferDetail {


    /**
     * 订单号
     */
    private String orderUniqueId;
    /**
     * 优惠描述
     */
    private String cheapDescription;

    /**
     *  优惠金额
     */
    private String cheapMoney;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

}
