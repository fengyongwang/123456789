package com.merchant.shop.dao.impl;

import com.merchant.shop.dao.CommodityDao;
import com.merchant.shop.mapper.CommodityMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/4
 */
@Log4j
@Component
public class CommodityDaoImpl implements CommodityDao {

    @Resource
    private CommodityMapper commodityMapper;

}
