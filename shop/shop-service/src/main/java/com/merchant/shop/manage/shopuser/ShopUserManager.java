package com.merchant.shop.manage.shopuser;

import com.merchant.shop.bo.shopuser.request.ShopUserBORequest;
import com.merchant.shop.bo.shopuser.result.ShopUserBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/9
 */
public interface ShopUserManager {


    /**
     * 添加商铺
     * @param shopUserBORequest
     * @return
     */
    ShopUserBOResult insertShop(ShopUserBORequest shopUserBORequest);

}
