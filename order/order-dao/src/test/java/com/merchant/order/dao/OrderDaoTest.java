package com.merchant.order.dao;

import com.merchant.data.po.result.CommonResultPO;
import com.merchant.order.OrderDao;
import com.merchant.order.base.BaseDaoTest;
import com.merchant.order.constant.order.OrderConstant;
import com.merchant.order.po.data.CommodityOrder;
import com.merchant.order.po.request.CommodityOrderRequest;
import com.merchant.order.po.result.CommodityOrderResult;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

public class OrderDaoTest extends BaseDaoTest {


    @Resource
    private OrderDao orderDao;

    @Test
    public void createOrder() {

        CommodityOrder commodityOrder=new CommodityOrder();
        commodityOrder.setPlatform(OrderConstant.OrderPlatform.MMALPLATFORM);
        commodityOrder.setOrderStatus(OrderConstant.OrderStatusConstant.ORDERCOMPLETE);
        commodityOrder.setOrderNumber("1234556787");
        commodityOrder.setUpdateOrderTime(new Date());
        commodityOrder.setCreateOrderTime(new Date());
        commodityOrder.setOrderUniqueId(UUID.randomUUID().toString().replaceAll("-", ""));
        commodityOrder.setCurrentTotalPrice("140");
        commodityOrder.setOriginalTotalPrice("180");
        commodityOrder.setRewardAddress("上海市浦东新区");
        commodityOrder.setRewardPhone("18016302686");
        commodityOrder.setRewardName("王先生");
        CommonResultPO commonResultPO=orderDao.createOrder(commodityOrder);
        System.out.println(commonResultPO.getMessage());
    }

    @Test
    public void updateOrderStatus() {
        CommodityOrder commodityOrder=new CommodityOrder();
        commodityOrder.setOrderUniqueId("5694d19baa9241da8ce343757cf0b91b");
        commodityOrder.setOrderStatus(OrderConstant.OrderStatusConstant.ORDERCOMPLETE);

        CommonResultPO commonResultPO=orderDao.updateOrderStatus(commodityOrder);
        System.out.println(commonResultPO.getMessage());

    }

    @Test
    public void queryCommodityOrderByrequest() {
        CommodityOrderRequest commodityOrderRequest=new CommodityOrderRequest();
        commodityOrderRequest.setOrderNumber("MMAL19060380008");
        CommodityOrderResult commodityOrderResult= orderDao.queryCommodityOrderByrequest(commodityOrderRequest);
        for (CommodityOrder commodityOrder:commodityOrderResult.getValues()) {
            System.out.println(commodityOrder.toString());
        }
    }

    @Test
    public void queryCommodityOrderByrequestGroup() {
    }
}