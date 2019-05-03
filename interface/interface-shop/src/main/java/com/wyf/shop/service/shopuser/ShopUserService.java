package com.wyf.shop.service.shopuser;

import com.wyf.shop.bo.request.ShopUserBORequest;
import com.wyf.shop.bo.result.ShopUserBOResult;

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
