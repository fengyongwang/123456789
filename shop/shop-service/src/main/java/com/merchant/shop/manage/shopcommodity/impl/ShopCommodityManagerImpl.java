package com.merchant.shop.manage.shopcommodity.impl;

import com.merchant.shop.bo.shopuser.request.ShopUserBORequest;
import com.merchant.shop.bo.shopuser.result.ShopUserBOResult;
import com.merchant.shop.manage.shopuser.ShopUserManager;
import com.merchant.user.bo.CommonBOResult;
import com.merchant.convert.ConvertManager;
import com.merchant.shop.dao.ShopCommodityDao;
import com.merchant.data.StatusEnum;
import com.merchant.shop.po.data.ShopCommodity;
import com.merchant.shop.po.request.ShopCommodityRequest;
import com.merchant.shop.po.result.ShopCommodityResult;
import com.merchant.shop.bo.shopcommodity.data.ShopCommodityBO;
import com.merchant.shop.bo.shopcommodity.param.ShopCommodityParamBO;
import com.merchant.shop.bo.shopcommodity.request.ShopCommodityBORequest;
import com.merchant.shop.bo.shopcommodity.result.ShopCommodityBOResult;
import com.merchant.shop.manage.shopcommodity.ShopCommodityManager;
import com.merchant.user.util.ResultShopServiceCodeUtil;
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
    private ShopUserManager shopUserManager;

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
        ShopCommodityBOResult shopCommodityBOResult = new ShopCommodityBOResult();
        Integer shopId = this.queryShopIdByUserId(shopCommodityBORequest.getUserId());
        if (shopId == 0) {
            return shopCommodityBOResult;
        }

        ShopCommodityRequest shopCommodityRequest = convertManager.tran(shopCommodityBORequest, ShopCommodityRequest.class);
        shopCommodityRequest.setShopId(shopId);
        ShopCommodityResult shopCommodityResult = shopCommodityDao.queryShopCommodityByRequest(shopCommodityRequest);
        if (!shopCommodityResult.isSuccess()) {
            log.error("query shopCommodity by request error in shopCommodityManager ...");
            return shopCommodityBOResult;
        }
        shopCommodityBOResult.setShopCommodityList(convertManager.convertList(shopCommodityResult.getValues(), ShopCommodityBO.class));
        ResultShopServiceCodeUtil.resultSuccess(shopCommodityBOResult);
        return shopCommodityBOResult;
    }

    /**
     * 根据userId查询商铺id
     *
     * @param userId
     * @return
     */
    private Integer queryShopIdByUserId(Integer userId) {
        ShopUserBORequest shopUserBORequest = new ShopUserBORequest();
        if (userId == null) {
            return 0;
        }
        shopUserBORequest.setUserId(userId);
        ShopUserBOResult shopUserBOResult = shopUserManager.queryShopUserByRequest(shopUserBORequest);
        if (shopUserBOResult.isFailed()) {
            log.error("query shopId by userId error in queryShopIdByUserId ...");
            return 0;
        }
        if (shopUserBOResult.getShopUserList().size() == 0) {
            log.warn("sorry,you do not have any shop ...");
            return 0;
        }
        if (shopUserBOResult.getShopUserList().size() > 1) {
            log.warn("sorry,one user only have one shop ...");
            return 0;
        }
        Integer shopId = shopUserBOResult.getShopUserList().get(0).getId();
        if (shopId == null) {
            log.error("you shop do not have id ...");
            return 0;
        }
        return shopId;
    }

}
