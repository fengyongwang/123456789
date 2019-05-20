package com.merchant.shop.manage.reginon.impl;

import com.merchant.convert.ConvertManager;
import com.merchant.user.dao.RegionDao;
import com.merchant.user.po.request.ReginonRequest;
import com.merchant.user.po.result.ReginonResult;
import com.merchant.shop.bo.reginon.data.ReginonBO;
import com.merchant.shop.bo.reginon.request.ReginonBORequest;
import com.merchant.shop.bo.reginon.result.ReginonBOResult;
import com.merchant.shop.manage.reginon.ReginonManage;
import com.merchant.shop.util.ResultShopServiceCodeUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/8
 */
@Component
@Log4j
public class ReginonManageImpl implements ReginonManage {


    @Resource
    private RegionDao regionDao;

    @Resource
    private ConvertManager convertManager;

    @Override
    public ReginonBOResult queryReginonByRequest(ReginonBORequest reginonBORequest) {
        ReginonBOResult reginonBOResult = new ReginonBOResult();
        log.info("start query reginon in reginonManage ...");

        ReginonRequest reginonRequest = convertManager.tran(reginonBORequest, ReginonRequest.class);
        /**
         * 默认不分页
         */
        reginonRequest.setPaging(false);
        ReginonResult regionResult = regionDao.queryRegionByRequest(reginonRequest);
        if (!regionResult.isSuccess()) {
            log.error("regionDao RegionByRequest error in ReginonManage...");
            return reginonBOResult;
        }

        reginonBOResult.setReginonList(convertManager.convertList(regionResult.getValues(), ReginonBO.class));
        ResultShopServiceCodeUtil.resultSuccess(reginonBOResult);

        return reginonBOResult;
    }
}
