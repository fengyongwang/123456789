package com.merchant.shop.bo.shopuser.data;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/13
 */
@Data
public class TotalCommodityBO implements Serializable {
    private static final long serialVersionUID = 9204650469304123176L;

    /**
     * 商品分类得id
     */
    private Integer id;

    /**
     * 商品分类得名称
     */
    private String commodityTypeName;

}
