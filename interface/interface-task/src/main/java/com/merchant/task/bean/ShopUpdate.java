package com.merchant.task.bean;

import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/31
 */
@Data
public class ShopUpdate {

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 店家id
     */
    private Integer userId;

    /**
     * 商铺名称
     */
    private String shopName;

    /**
     * 主营商品分类id
     */
    private Integer totalCommodityId;
    /**
     * 商铺编码
     */
    private String shopCode;
    /**
     * 商铺地址
     */
    private String shopAddress;
    /**
     * 商铺联系人
     */
    private String shopContact;
    /**
     * 商铺电话
     */
    private String shopPhone;

}
