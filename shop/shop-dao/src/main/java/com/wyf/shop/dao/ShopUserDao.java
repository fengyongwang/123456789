package com.wyf.shop.dao;

import com.wyf.shop.po.data.ShopUser;
import com.wyf.shop.po.result.ShopUserResult;

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
