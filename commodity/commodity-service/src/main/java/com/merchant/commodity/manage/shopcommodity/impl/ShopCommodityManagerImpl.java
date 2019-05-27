package com.merchant.commodity.manage.shopcommodity.impl;

import com.merchant.commodity.dao.ShopCommodityDao;
import com.merchant.commodity.po.data.ShopCommodity;
import com.merchant.commodity.po.request.ShopCommodityRequest;
import com.merchant.commodity.po.result.ShopCommodityResult;
import com.merchant.commodity.util.ResultCommodityServiceCodeUtil;
import com.merchant.shop.bo.shopuser.request.ShopUserBORequest;
import com.merchant.shop.bo.shopuser.result.ShopUserBOResult;
import com.merchant.shop.service.ShopUserService;
import com.merchant.user.bo.CommonBOResult;
import com.merchant.convert.ConvertManager;
import com.merchant.data.StatusEnum;
import com.merchant.commodity.bo.shopcommodity.data.ShopCommodityBO;
import com.merchant.commodity.bo.shopcommodity.param.ShopCommodityParamBO;
import com.merchant.commodity.bo.shopcommodity.request.ShopCommodityBORequest;
import com.merchant.commodity.bo.shopcommodity.result.ShopCommodityBOResult;
import com.merchant.commodity.manage.shopcommodity.ShopCommodityManager;
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
    private ShopUserService shopUserService;

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
        ResultCommodityServiceCodeUtil.resultSuccess(shopCommodityBOResult);

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
        ResultCommodityServiceCodeUtil.resultSuccess(commonBOResult);

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
        ResultCommodityServiceCodeUtil.resultSuccess(shopCommodityBOResult);
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
        ShopUserBOResult shopUserBOResult = shopUserService.queryShopUserByRequest(shopUserBORequest);
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
