package com.merchant.commodity.bo.shopcommodity.result;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.commodity.bo.shopcommodity.data.ShopCommodityBO;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/20
 */
@Data
public class ShopCommodityBOResult extends CommonBOResult {


    /**
     * 所有得商品集合
     */
    private List<ShopCommodityBO> shopCommodityList;
}
