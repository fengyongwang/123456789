package com.merchant.shop.service;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.shop.bo.shopuser.request.ShopUserBORequest;
import com.merchant.shop.bo.shopuser.result.ShopUserBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/9
 */
public interface ShopUserService {


    /**
     * 添加商铺
     *
     * @param shopUserBORequest
     * @return
     */
    ShopUserBOResult insertShop(ShopUserBORequest shopUserBORequest);


    /**
     * 根据条件查询
     *
     * @param shopUserBORequest
     * @return
     */
    ShopUserBOResult queryShopUserByRequest(ShopUserBORequest shopUserBORequest);


    /**
     * 根据条件修改商铺
     * @param shopUserBORequest
     * @return
     */
    CommonBOResult updateShopByRequest(ShopUserBORequest shopUserBORequest);




}
