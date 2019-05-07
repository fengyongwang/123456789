package com.merchant.shop.bo.shopcommodity.result;

import com.merchant.bo.CommonBOResult;
import com.merchant.shop.bo.shopcommodity.data.ShopCommodityBO;
import lombok.Data;

import java.util.List;

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
    private List<ShopCommodityBO> shopCommodityList;

}
