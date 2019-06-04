package com.merchant.order.impl;

import com.merchant.data.po.result.CommonResultPO;
import com.merchant.order.OrderOfferDetailDao;
import com.merchant.order.po.data.CommodityOrderOfferDetail;
import com.merchant.order.util.ResultOrderUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/6/3
 */
@Log4j
@Component
public class OrderOfferDetailDaoImpl implements OrderOfferDetailDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public CommonResultPO createOrderOfferDetail(CommodityOrderOfferDetail commodityOrderOfferDetail) {
        CommonResultPO commonResultPO = new CommonResultPO();
        try {
            mongoTemplate.save(commodityOrderOfferDetail);
            ResultOrderUtil.resultSuccess(commonResultPO);
            commonResultPO.setCount(1);
        } catch (Exception e) {
            log.error("save orderOfferDetail error in OrderOfferDetailDao ...",e);

        }
        return commonResultPO;
    }
}
