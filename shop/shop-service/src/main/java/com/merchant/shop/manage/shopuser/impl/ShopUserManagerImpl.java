package com.merchant.shop.manage.shopuser.impl;

import com.merchant.dao.ShopUserDao;
import com.merchant.shop.bo.shopuser.request.ShopUserBORequest;
import com.merchant.shop.bo.shopuser.result.ShopUserBOResult;
import com.merchant.shop.manage.shopuser.ShopUserManager;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/9
 */
@Component
@Log4j
public class ShopUserManagerImpl implements ShopUserManager {

    @Resource
    private ShopUserDao shopUserDao;


    @Override
    public ShopUserBOResult insertShop(ShopUserBORequest shopUserBORequest) {
        return null;
    }
}
