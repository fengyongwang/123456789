package com.merchant.shop.service.shopuser;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.shop.bo.shopuser.request.ShopUserBORequest;
import com.merchant.shop.bo.shopuser.result.ShopUserBOResult;
import com.merchant.shop.manage.shopuser.ShopUserManager;
import com.merchant.shop.service.ShopUserService;
import com.merchant.user.bo.ResultConstant;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/9
 */
@Log4j
@Service
@com.alibaba.dubbo.config.annotation.Service
public class ShopUserServiceImpl implements ShopUserService {


    @Resource
    private ShopUserManager shopUserManager;

    @Override
    public ShopUserBOResult insertShop(ShopUserBORequest shopUserBORequest) {
        ShopUserBORequest request = new ShopUserBORequest();
        request.setShopPhone(shopUserBORequest.getShopPhone());
        ShopUserBOResult shopUserBOResult = this.shopUserManager.queryShopUserByRequest(request);
        if (shopUserBOResult.isFailed()) {
            log.error("query shopUser By phone error in insertShop ...");
            return shopUserBOResult;
        }
        if (shopUserBOResult.getShopUserList().size() > 0) {
            log.warn("sorry, you already have shop ...");
            shopUserBOResult.setMessage("you already have shop");
            shopUserBOResult.setStatus(ResultConstant.CODE.ERROR);
            return shopUserBOResult;
        }
        return this.shopUserManager.insertShop(shopUserBORequest);
    }

    @Override
    public ShopUserBOResult queryShopUserByRequest(ShopUserBORequest shopUserBORequest) {
        return this.shopUserManager.queryShopUserByRequest(shopUserBORequest);
    }

    @Override
    public CommonBOResult updateShopByRequest(ShopUserBORequest shopUserBORequest) {


        return this.shopUserManager.updateShopByRequest(shopUserBORequest);
    }
}
