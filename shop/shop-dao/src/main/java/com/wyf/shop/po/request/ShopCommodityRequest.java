package com.wyf.shop.po.request;

import com.wyf.data.po.request.CommonRequestPO;
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
     * 单价
     */
    private Double unitPrice;
    /**
     * 库存
     */
    private Integer stock;
}
