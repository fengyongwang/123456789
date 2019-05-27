package com.merchant.commodity.bo.shopcommodity.request;

import com.merchant.user.bo.CommonBORequest;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/20
 */
@Data
public class ShopCommodityBORequest extends CommonBORequest {
    private static final long serialVersionUID = -6294055291974246278L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 最大单价
     */
    private Double maxUnitPrice;
    /**
     * 最小单价
     */
    private Double minUnitPrice;
    /**
     * 最大库存
     */
    private Integer maxStock;
    /**
     * 最小库存
     */
    private Integer minStock;
    /**
     * 最大月销量
     */
    private Integer maxMonthSaleNumber;
    /**
     * 最小月销量
     */
    private Integer minMonthSaleNumber;
    /**
     * 最大总销量
     */
    private Integer maxTotalSaleNumber;
    /**
     * 最小总销量
     */
    private Integer minTotalSaleNumber;

    /**
     * 商家id
     */
    private Integer userId;
}
