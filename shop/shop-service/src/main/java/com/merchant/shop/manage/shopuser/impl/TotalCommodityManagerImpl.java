package com.merchant.shop.manage.shopuser.impl;

import com.merchant.convert.ConvertManager;
import com.merchant.dao.TotalCommodityDao;
import com.merchant.po.request.TotalCommodityRequest;
import com.merchant.po.result.TotalCommodityResult;
import com.merchant.shop.bo.shopuser.request.TotalCommodityBORequest;
import com.merchant.shop.bo.shopuser.result.TotalCommodityBOResult;
import com.merchant.shop.manage.shopuser.TotalCommodityManager;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/13
 */
@Component
@Log4j
public class TotalCommodityManagerImpl implements TotalCommodityManager {

    @Resource
    private TotalCommodityDao totalCommodityDao;


    @Resource
    private ConvertManager convertManager;

    @Override
    public TotalCommodityBOResult queryTotalCommodity(TotalCommodityBORequest totalCommodityBORequest) {
        TotalCommodityBOResult totalCommodityBOResult=new TotalCommodityBOResult();
        TotalCommodityResult totalCommodityResult= totalCommodityDao.queryByRequest(convertManager.tran(totalCommodityBORequest, TotalCommodityRequest.class));
        if(!totalCommodityResult.isSuccess()){

        }

        return totalCommodityBOResult;
    }
}
