package com.wyf.shop.dao;

import com.wyf.shop.po.data.ShopCommodity;
import com.wyf.shop.po.result.ShopCommodityResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/2
 */
public interface ShopCommodityDao {

    /**
     * 添加一个商品
     * @param shopCommodity
     * @return
     */
    ShopCommodityResult insertShopCommodity(ShopCommodity shopCommodity);

}
