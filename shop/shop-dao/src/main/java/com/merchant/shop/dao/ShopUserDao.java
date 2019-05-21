package com.merchant.shop.dao;

import com.merchant.shop.po.data.ShopUser;
import com.merchant.shop.po.request.ShopUserRequest;
import com.merchant.shop.po.result.ShopUserResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/2
 */
public interface ShopUserDao {

    /**
     * 添加一个shopUser
     *
     * @param shopUser
     * @return
     */
    ShopUserResult insertUser(ShopUser shopUser);

    /**
     * 根据条件去查商铺商家关联表
     *
     * @param shopUserRequest
     * @return
     */
    ShopUserResult queryShopUserByRequest(ShopUserRequest shopUserRequest);

    /**
     * 修改商户得商铺
     * @param shopUser
     * @return
     */
    ShopUserResult updateShopUserById(ShopUser shopUser);

}
