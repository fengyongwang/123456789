package com.merchant.shop.manage.shopcommodity.impl;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.convert.ConvertManager;
import com.merchant.user.dao.ShopCommodityDao;
import com.merchant.data.StatusEnum;
import com.merchant.user.po.data.ShopCommodity;
import com.merchant.user.po.request.ShopCommodityRequest;
import com.merchant.user.po.result.ShopCommodityResult;
import com.merchant.shop.bo.shopcommodity.data.ShopCommodityBO;
import com.merchant.shop.bo.shopcommodity.param.ShopCommodityParamBO;
import com.merchant.shop.bo.shopcommodity.request.ShopCommodityBORequest;
import com.merchant.shop.bo.shopcommodity.result.ShopCommodityBOResult;
import com.merchant.shop.manage.shopcommodity.ShopCommodityManager;
import com.merchant.shop.util.ResultShopServiceCodeUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/20
 */
@Component
@Log4j
public class ShopCommodityManagerImpl implements ShopCommodityManager {

    @Resource
    private ShopCommodityDao shopCommodityDao;

    @Resource
    private ConvertManager convertManager;

    @Override
    public ShopCommodityBOResult insertShopCommodity(ShopCommodityParamBO shopCommodityBORequest) {
        ShopCommodityBOResult shopCommodityBOResult = new ShopCommodityBOResult();
        ShopCommodity shopCommodity = convertManager.tran(shopCommodityBORequest, ShopCommodity.class);
        shopCommodity.setStatus(StatusEnum.EFFECTIVE.getValue());
        ShopCommodityResult shopCommodityResult = shopCommodityDao.insertShopCommodity(shopCommodity);
        if (!shopCommodityResult.isSuccess() || shopCommodityResult.getCount() == 0) {
            log.error("insert commodity to shop error in shopCommodityManager ...");
            return shopCommodityBOResult;
        }

        shopCommodityBOResult.setShopCommodityList(convertManager.convertList(shopCommodityResult.getValues(), ShopCommodityBO.class));
        ResultShopServiceCodeUtil.resultSuccess(shopCommodityBOResult);

        return shopCommodityBOResult;
    }

    @Override
    public CommonBOResult updateShopCommodityByRequest(ShopCommodityParamBO shopCommodityBORequest) {
        CommonBOResult commonBOResult = new CommonBOResult();

        ShopCommodity shopCommodity = convertManager.tran(shopCommodityBORequest, ShopCommodity.class);
        ShopCommodityResult shopCommodityResult = shopCommodityDao.updateShopCommodityById(shopCommodity);
        if (!shopCommodityResult.isSuccess()) {
            log.error("update shopCommodity error in shopCommodityManager ...");
            return commonBOResult;
        }
        ResultShopServiceCodeUtil.resultSuccess(commonBOResult);

        return commonBOResult;
    }

    @Override
    public ShopCommodityBOResult queryShopCommodityByRequest(ShopCommodityBORequest shopCommodityBORequest) {
        ShopCommodityBOResult shopCommodityBOResult=new ShopCommodityBOResult();

        ShopCommodityRequest shopCommodityRequest = convertManager.tran(shopCommodityBORequest, ShopCommodityRequest.class);
        ShopCommodityResult shopCommodityResult= shopCommodityDao.queryShopCommodityByRequest(shopCommodityRequest);
        if(!shopCommodityResult.isSuccess()){
            log.error("query shopCommodity by request error in shopCommodityManager ...");
            return shopCommodityBOResult;
        }
        shopCommodityBOResult.setShopCommodityList(convertManager.convertList(shopCommodityResult.getValues(),ShopCommodityBO.class));
        ResultShopServiceCodeUtil.resultSuccess(shopCommodityBOResult);
        return shopCommodityBOResult;
    }
}
