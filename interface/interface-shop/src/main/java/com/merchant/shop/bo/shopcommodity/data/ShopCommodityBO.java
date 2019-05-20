package com.merchant.shop.bo.shopcommodity.data;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/20
 */
@Data
public class ShopCommodityBO implements Serializable {
    private static final long serialVersionUID = -4625906005552479349L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 商家id
     */
    private Integer shopId;
    /**
     * 商品分类id，即商品表的主键id
     */
    private Integer totalCommodityId;

    /**
     * 商品名称
     */
    private String commodityName;
    /**
     * 单价
     */
    private Double unitPrice;
    /**
     * 库存
     */
    private Integer stock;

    /**
     * 月销量
     */
    private Integer monthSaleNumber;
    /**
     * 月销额
     */
    private Double monthSalePrice;
    /**
     * 总销量
     */
    private Integer totalSaleNumber;
    /**
     * 总销金额
     */
    private Double totalSalePrice;
    /**
     * 商品图片
     */
    private String imageUrl;
    /**
     * 商品描述
     */
    private String commodityDescription;

}
