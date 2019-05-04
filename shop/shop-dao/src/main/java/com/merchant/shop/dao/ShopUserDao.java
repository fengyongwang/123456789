package com.merchant.shop.dao;

import com.merchant.shop.po.data.ShopUser;
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
     * @param shopUser
     * @return
     */
   ShopUserResult insertUser(ShopUser shopUser);

}
