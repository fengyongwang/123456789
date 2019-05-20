package com.merchant.shop.service;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.shop.bo.shopcommodity.param.ShopCommodityParamBO;
import com.merchant.shop.bo.shopcommodity.request.ShopCommodityBORequest;
import com.merchant.shop.bo.shopcommodity.result.ShopCommodityBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/20
 */
public interface ShopCommodityService {

    /**
     * 往一个商铺中添加一个商品
     * @param shopCommodityBORequest
     * @return
     */
    ShopCommodityBOResult insertShopCommodity(ShopCommodityParamBO shopCommodityBORequest);

    /**
     * 修改该商品得属性
     * @param shopCommodityBORequest
     * @return
     */
    CommonBOResult updateShopCommodityByRequest(ShopCommodityParamBO shopCommodityBORequest);


    /**
     * 根据条件查询相关商品
     * @param shopCommodityBORequest
     * @return
     */
    ShopCommodityBOResult queryShopCommodityByRequest(ShopCommodityBORequest shopCommodityBORequest);
}