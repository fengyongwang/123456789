package com.merchant.shop.service.shopuser;

import com.merchant.shop.bo.shopuser.request.ShopUserBORequest;
import com.merchant.shop.bo.shopuser.result.ShopUserBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/3
 */
public interface ShopUserService {

    /**
     * 添加一个门店
     * @param shopUserBORequest
     * @return
     */
    ShopUserBOResult insertShop(ShopUserBORequest shopUserBORequest);

}
