package com.merchant.order.manage.order.impl;

import com.merchant.convert.ConvertManager;
import com.merchant.data.po.result.CommonResultPO;
import com.merchant.order.bo.order.request.OrderBORequest;
import com.merchant.order.constant.order.OrderConstant;
import com.merchant.order.dao.order.OrderDao;
import com.merchant.order.manage.order.OrderManager;
import com.merchant.order.po.data.CommodityOrder;
import com.merchant.order.util.ResultOrderServiceCodeUtil;
import com.merchant.user.bo.CommonBOResult;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/24
 */
@Component
@Log4j
public class OrderManagerImpl implements OrderManager {

    @Resource
    private OrderDao orderDao;

    @Resource
    private ConvertManager convertManager;

    @Override
    public CommonBOResult createOrder(OrderBORequest orderBORequest) {
        CommonBOResult commonBOResult=new CommonBOResult();
        CommodityOrder commodityOrder = convertManager.tran(orderBORequest, CommodityOrder.class);

        CommonResultPO result= orderDao.createOrder(commodityOrder);
        if(!result.isSuccess()){
            log.error("create order error in createOrder ...");
            return commonBOResult;
        }

        ResultOrderServiceCodeUtil.resultSuccess(commonBOResult);
        return commonBOResult;
    }

    /**
     * 拼装订单信息
     *
     * @param commodityOrder
     * @return
     */
    private CommodityOrder AssembleOrderInformation(CommodityOrder commodityOrder) {
        /**
         * 生成订单号uuid
         */
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        log.info("create orderUniqueId is :"+uuid+" in AssembleOrderInformation ...");
        commodityOrder.setOrderUniqueId(uuid);
        commodityOrder.setCreateOrderTime(new Date());
        commodityOrder.setUpdateOrderTime(new Date());
        commodityOrder.setOrderStatus(OrderConstant.OrderStatusConstant.TOBEPAYORDER);
        commodityOrder.setOrderNumber(this.createOrderNumber(4));
        return commodityOrder;
    }

    /**
     * 生成订单流水号
     * @param length
     * @return
     */
    private String createOrderNumber(Integer length){

        DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        String nowDate=dateFormat.format(new Date());
        String randomNumber="";
        Random random=new Random();
        for(int i=0;i<length;i++){
          randomNumber+=random.nextInt(10);

        }

       return "mmal_"+nowDate+randomNumber;
    }

}
