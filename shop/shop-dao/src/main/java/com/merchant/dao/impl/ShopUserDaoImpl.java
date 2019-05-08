package com.merchant.dao.impl;

import com.merchant.dao.ShopUserDao;
import com.merchant.mapper.ShopUserMapper;
import com.merchant.po.data.ShopUser;
import com.merchant.po.result.ShopUserResult;
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
