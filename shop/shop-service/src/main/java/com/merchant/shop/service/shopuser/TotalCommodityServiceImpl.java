package com.merchant.shop.service.shopuser;

import com.merchant.shop.bo.shopuser.request.TotalCommodityBORequest;
import com.merchant.shop.bo.shopuser.result.TotalCommodityBOResult;
import com.merchant.shop.manage.shopuser.TotalCommodityManager;
import com.merchant.shop.service.TotalCommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/13
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class TotalCommodityServiceImpl implements TotalCommodityService {

    @Resource
    private TotalCommodityManager totalCommodityManager;

    @Override
    public TotalCommodityBOResult queryTotalCommodity(TotalCommodityBORequest totalCommodityBORequest) {
        return this.totalCommodityManager.queryTotalCommodity(totalCommodityBORequest);
    }
}
