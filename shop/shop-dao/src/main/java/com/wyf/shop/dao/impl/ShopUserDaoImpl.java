package com.wyf.shop.dao.impl;

import com.wyf.shop.dao.ShopUserDao;
import com.wyf.shop.mapper.ShopUserMapper;
import com.wyf.shop.po.data.ShopUser;
import com.wyf.shop.po.result.ShopUserResult;
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
