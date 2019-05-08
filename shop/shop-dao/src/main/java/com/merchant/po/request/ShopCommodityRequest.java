package com.merchant.po.request;

import com.merchant.data.po.request.CommonRequestPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/2
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ShopCommodityRequest extends CommonRequestPO {

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 商品ids
     */
    private List<Integer> ids;

    /**
     * 商家id
     */
    private Integer shopId;

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
}
