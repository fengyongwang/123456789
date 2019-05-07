package com.merchant.shop.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.merchant.shop.dao.RegionDao;
import com.merchant.shop.mapper.RegionMapper;
import com.merchant.shop.po.data.Region;
import com.merchant.shop.po.request.RegionRequest;
import com.merchant.shop.po.result.RegionResult;
import com.merchant.shop.util.ResultShopUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/5
 */
@Component
@Log4j
public class RegionDaoImpl implements RegionDao {
    @Resource
    private RegionMapper regionMapper;

    @Override
    public RegionResult queryRegionByRequest(RegionRequest request) {

        RegionResult res = new RegionResult();
        try {
            LambdaQueryWrapper<Region> wp = new LambdaQueryWrapper<>();
            if (request.getId() != null) {
                wp.eq(Region::getId, request.getId());
            }
            if (request.getRegionLevel() != null) {
                wp.eq(Region::getRegionLevel, request.getRegionLevel());
            }
            if (request.getRegionParentId() != null) {
                wp.eq(Region::getRegionParentId, request.getRegionParentId());
            }
            if (request.isPaging()) {
                Page<Region> page = new Page<>(request.getPage() + 1, request.getPageSize());
                IPage<Region> zdAddressIPage = regionMapper.selectPage(page, wp);
                ResultShopUtil.resultValues(res, zdAddressIPage.getRecords());
                ResultShopUtil.resultCountWithPaging(res, (int) zdAddressIPage.getTotal(),request.getPage());
            } else {
                List<Region> list = regionMapper.selectList(wp);
                ResultShopUtil.resultValues(res, list);
            }
            ResultShopUtil.resultSuccess(res);
        } catch (Exception e) {
            log.error("RegionDao query error..........", e);
        }
        return res;
    }

    @Override
    public RegionResult insertRegion(Region region) {
        RegionResult res = new RegionResult();
        try {
            int status = regionMapper.insert(region);
            ResultShopUtil.dealUpsert(status, region, res);
        } catch (Exception e) {
            log.error("RegionDao insert error..........", e);
        }
        return res;
    }
}
