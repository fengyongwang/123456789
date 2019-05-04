package com.merchant.shop.dao.impl;

import com.merchant.shop.dao.ShopUserDao;
import com.merchant.shop.mapper.ShopUserMapper;
import com.merchant.shop.po.data.ShopUser;
import com.merchant.shop.po.result.ShopUserResult;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/2
 */
@Component
@Log4j
public class ShopUserDaoImpl implements ShopUserDao {

    @Resource
    private ShopUserMapper shopUserMapper;

    @Override
    public ShopUserResult insertUser(ShopUser shopUser) {
        return null;
    }
}
