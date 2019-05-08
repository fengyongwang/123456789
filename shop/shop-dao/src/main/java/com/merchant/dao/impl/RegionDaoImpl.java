package com.merchant.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.merchant.dao.RegionDao;
import com.merchant.mapper.RegionMapper;
import com.merchant.po.data.Reginon;
import com.merchant.po.request.ReginonRequest;
import com.merchant.po.result.ReginonResult;
import com.merchant.util.ResultShopUtil;
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
    public ReginonResult queryRegionByRequest(ReginonRequest request) {

        ReginonResult res = new ReginonResult();
        try {
            LambdaQueryWrapper<Reginon> wp = new LambdaQueryWrapper<>();
            if (request.getId() != null) {
                wp.eq(Reginon::getId, request.getId());
            }
            if (request.getRegionLevel() != null) {
                wp.eq(Reginon::getRegionLevel, request.getRegionLevel());
            }
            if (request.getRegionParentId() != null) {
                wp.eq(Reginon::getRegionParentId, request.getRegionParentId());
            }
            if (request.isPaging()) {
                Page<Reginon> page = new Page<>(request.getPage() + 1, request.getPageSize());
                IPage<Reginon> zdAddressIPage = regionMapper.selectPage(page, wp);
                ResultShopUtil.resultValues(res, zdAddressIPage.getRecords());
                ResultShopUtil.resultCountWithPaging(res, (int) zdAddressIPage.getTotal(),request.getPage());
            } else {
                List<Reginon> list = regionMapper.selectList(wp);
                ResultShopUtil.resultValues(res, list);
            }
            ResultShopUtil.resultSuccess(res);
        } catch (Exception e) {
            log.error("RegionDao query error..........", e);
        }
        return res;
    }

    @Override
    public ReginonResult insertRegion(Reginon region) {
        ReginonResult res = new ReginonResult();
        try {
            int status = regionMapper.insert(region);
            ResultShopUtil.dealUpsert(status, region, res);
        } catch (Exception e) {
            log.error("RegionDao insert error..........", e);
        }
        return res;
    }
}
