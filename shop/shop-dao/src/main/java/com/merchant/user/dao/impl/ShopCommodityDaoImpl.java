package com.merchant.user.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.merchant.user.mapper.ShopCommodityMapper;
import com.merchant.user.dao.ShopCommodityDao;
import com.merchant.user.po.data.ShopCommodity;
import com.merchant.user.po.request.ShopCommodityRequest;
import com.merchant.user.po.result.ShopCommodityResult;
import com.merchant.user.util.ResultShopUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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
    private ShopCommodityMapper mapper;

    @Override
    public ShopCommodityResult insertShopCommodity(ShopCommodity shopCommodity) {
        ShopCommodityResult res = new ShopCommodityResult();
        try {
            int status = mapper.insert(shopCommodity);
            ResultShopUtil.dealUpsert(status, shopCommodity, res);
        } catch (Exception e) {
            log.error("insert shopCommodity error in shopCommodityDao ...", e);
        }
        return res;
    }

    @Override
    public ShopCommodityResult updateShopCommodityById(ShopCommodity shopCommodity) {
        ShopCommodityResult res = new ShopCommodityResult();
        try {
            int status = mapper.updateById(shopCommodity);
            ResultShopUtil.dealUpsert(status, shopCommodity, res);
        } catch (Exception e) {
            log.error("update shopCommodity error in shopCommodityDao", e);
        }

        return res;
    }

    @Override
    public ShopCommodityResult queryShopCommodityByRequest(ShopCommodityRequest request) {
        ShopCommodityResult res = new ShopCommodityResult();
        try {
            LambdaQueryWrapper<ShopCommodity> wp = new LambdaQueryWrapper<>();
            if(request.getShopId()!=null){
                wp.eq(ShopCommodity::getShopId,request.getShopId());
            }
            if (!CollectionUtils.isEmpty(request.getShopIds())) {
                wp.in(ShopCommodity::getShopId, request.getShopIds());
            }
            if (request.getMaxMonthSaleNumber() != null) {
                wp.le(ShopCommodity::getMonthSaleNumber, request.getMaxMonthSaleNumber());
            }
            if(request.getMinMonthSaleNumber()!=null){
                wp.ge(ShopCommodity::getMonthSaleNumber, request.getMinMonthSaleNumber());
            }
            if(request.getMaxUnitPrice()!=null){
                wp.le(ShopCommodity::getUnitPrice, request.getMaxUnitPrice());
            }
            if(request.getMinUnitPrice()!=null){
                wp.ge(ShopCommodity::getUnitPrice, request.getMinUnitPrice());
            }
            if(request.getMaxStock()!=null){
                wp.le(ShopCommodity::getStock, request.getMaxStock());
            }
            if(request.getMinStock()!=null){
                wp.ge(ShopCommodity::getStock, request.getMinStock());
            }
            if(request.getMaxTotalSaleNumber()!=null){
                wp.le(ShopCommodity::getTotalSaleNumber, request.getMaxTotalSaleNumber());
            }
            if(request.getMinTotalSaleNumber()!=null){
                wp.ge(ShopCommodity::getTotalSaleNumber, request.getMinTotalSaleNumber());
            }
            /**
             * 按照创建时间升序排序
             */

            wp.orderByAsc(ShopCommodity::getCreateTime);


            if (request.isPaging()) {
                Page<ShopCommodity> page = new Page<>(request.getPage() + 1, request.getPageSize());
                IPage<ShopCommodity> shopCommodityIPage = mapper.selectPage(page, wp);
                ResultShopUtil.resultValues(res, shopCommodityIPage.getRecords());
                ResultShopUtil.resultCountWithPaging(res, (int) shopCommodityIPage.getTotal(), request.getPage());
            } else {
                List<ShopCommodity> list = mapper.selectList(wp);
                ResultShopUtil.resultValues(res, list);
            }
            ResultShopUtil.resultSuccess(res);


        } catch (Exception e) {
            log.error("query shopCommodity by request error in shopCommodityDao ...",e);
        }

        return res;
    }
}
