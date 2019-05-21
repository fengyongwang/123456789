package com.merchant.shop.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.merchant.shop.dao.TotalCommodityDao;
import com.merchant.shop.mapper.TotalCommodityMapper;
import com.merchant.shop.po.data.TotalCommodity;
import com.merchant.shop.po.request.TotalCommodityRequest;
import com.merchant.shop.po.result.TotalCommodityResult;
import com.merchant.user.util.ResultShopUtil;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/4
 */
@Log4j
@Component
public class TotalCommodityDaoImpl implements TotalCommodityDao {

    @Resource
    private TotalCommodityMapper mapper;

    @Override
    public TotalCommodityResult insert(TotalCommodity totalCommodity) {

        TotalCommodityResult res=new TotalCommodityResult();
        try {
            int status = mapper.insert(totalCommodity);
            ResultShopUtil.dealUpsert(status, totalCommodity, res);
        } catch (Exception e) {
            log.error("TotalCommodityDao insert error..........", e);
        }
        return res;
    }

    @Override
    public TotalCommodityResult queryByRequest(TotalCommodityRequest request) {
        TotalCommodityResult res=new TotalCommodityResult();
        try {
            LambdaQueryWrapper<TotalCommodity> wp = new LambdaQueryWrapper<>();
            if (request.getId() != null) {
                wp.eq(TotalCommodity::getId, request.getId());
            }
            if(StringUtils.isNotBlank(request.getCommodityTypeName())){
                wp.eq(TotalCommodity::getCommodityTypeName,request.getCommodityTypeName());
            }
            if (!CollectionUtils.isEmpty(request.getIds())) {
                wp.in(TotalCommodity::getId, request.getIds());
            }

            if (request.isPaging()) {
                Page<TotalCommodity> page = new Page<>(request.getPage() + 1, request.getPageSize());
                IPage<TotalCommodity> totalCommodityIPage = mapper.selectPage(page, wp);
                ResultShopUtil.resultValues(res, totalCommodityIPage.getRecords());
                ResultShopUtil.resultCountWithPaging(res, (int) totalCommodityIPage.getTotal(), request.getPage());
            } else {
                List<TotalCommodity> list = mapper.selectList(wp);
                ResultShopUtil.resultValues(res, list);
            }
            ResultShopUtil.resultSuccess(res);
        } catch (Exception e) {
            log.error("TotalCommodityDao simpleQueryByRequest error..........", e);
        }
        return res;
    }
}
