package com.merchant.shop.bo.shopcommodity.result;

import com.merchant.bo.CommonBOResult;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/4
 */
@Data
public class ShopCommodityBOResult extends CommonBOResult {

    /**
     *
     */
    private List<ShopCommodityBO>shopCommodityList;

}
