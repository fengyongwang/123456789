package com.merchant.dao.impl;

import com.merchant.mapper.ShopCommodityMapper;
import com.merchant.dao.ShopCommodityDao;
import com.merchant.po.data.ShopCommodity;
import com.merchant.po.result.ShopCommodityResult;
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
public class ShopCommodityDaoImpl implements ShopCommodityDao {

    @Resource
    private ShopCommodityMapper shopCommodityMapper;

    @Override
    public ShopCommodityResult insertShopCommodity(ShopCommodity shopCommodity) {
        return null;
    }
}
