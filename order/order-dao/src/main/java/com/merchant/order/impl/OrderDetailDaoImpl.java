package com.merchant.order.impl;

import com.merchant.data.po.result.CommonResultPO;
import com.merchant.order.OrderDetailDao;
import com.merchant.order.po.data.CommodityOrderDetail;
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
@Component
@Log4j
public class OrderDetailDaoImpl implements OrderDetailDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public CommonResultPO createOrderDetail(CommodityOrderDetail commodityOrderDetail) {
        CommonResultPO commonResultPO = new CommonResultPO();
        try {
            mongoTemplate.save(commodityOrderDetail);
            ResultOrderUtil.resultSuccess(commonResultPO);
            commonResultPO.setCount(1);
        } catch (Exception e) {
            log.error("save orderDETAIL error in OrderDetailDao ...",e);

        }
        return commonResultPO;
    }
}
