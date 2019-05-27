package com.merchant.commodity.dao;


import com.merchant.commodity.po.data.ShopCommodity;
import com.merchant.commodity.po.request.ShopCommodityRequest;
import com.merchant.commodity.po.result.ShopCommodityResult;

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

    /**
     * 修改该商品得属性
     * @param shopCommodity
     * @return
     */
    ShopCommodityResult updateShopCommodityById(ShopCommodity shopCommodity);


    /**
     * 根据条件去查询相关商品
     * @param shopCommodityRequest
     * @return
     */
    ShopCommodityResult queryShopCommodityByRequest(ShopCommodityRequest shopCommodityRequest);

}
