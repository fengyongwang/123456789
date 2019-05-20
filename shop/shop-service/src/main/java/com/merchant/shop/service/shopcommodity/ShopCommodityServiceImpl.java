package com.merchant.shop.service.shopcommodity;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.shop.bo.shopcommodity.param.ShopCommodityParamBO;
import com.merchant.shop.bo.shopcommodity.request.ShopCommodityBORequest;
import com.merchant.shop.bo.shopcommodity.result.ShopCommodityBOResult;
import com.merchant.shop.manage.shopcommodity.ShopCommodityManager;
import com.merchant.shop.service.ShopCommodityService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/20
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
@Log4j
public class ShopCommodityServiceImpl implements ShopCommodityService {

    @Resource
    private ShopCommodityManager shopCommodityManager;

    @Override
    public ShopCommodityBOResult insertShopCommodity(ShopCommodityParamBO shopCommodityBORequest) {
        return this.shopCommodityManager.insertShopCommodity(shopCommodityBORequest);
    }

    @Override
    public CommonBOResult updateShopCommodityByRequest(ShopCommodityParamBO shopCommodityBORequest) {
        return this.shopCommodityManager.updateShopCommodityByRequest(shopCommodityBORequest);
    }

    @Override
    public ShopCommodityBOResult queryShopCommodityByRequest(ShopCommodityBORequest shopCommodityBORequest) {
        return this.shopCommodityManager.queryShopCommodityByRequest(shopCommodityBORequest);
    }
}
