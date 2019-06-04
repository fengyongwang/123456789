package com.merchant.order.manage.order.impl;

import com.merchant.convert.ConvertManager;
import com.merchant.data.po.result.CommonResultPO;
import com.merchant.order.bo.order.param.OrderCheapDetailParamBO;
import com.merchant.order.bo.order.param.OrderDetailParamBO;
import com.merchant.order.bo.order.request.OrderBORequest;
import com.merchant.order.constant.order.OrderConstant;
import com.merchant.order.OrderDao;
import com.merchant.order.OrderDetailDao;
import com.merchant.order.OrderOfferDetailDao;
import com.merchant.order.manage.order.OrderManager;
import com.merchant.order.manage.order.OrderNumberManager;
import com.merchant.order.po.data.CommodityOrder;
import com.merchant.order.po.data.CommodityOrderDetail;
import com.merchant.order.po.data.CommodityOrderOfferDetail;
import com.merchant.order.util.ResultOrderServiceCodeUtil;
import com.merchant.user.bo.CommonBOResult;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
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
    private OrderNumberManager orderNumberManager;

    @Resource
    private OrderDetailDao orderDetailDao;

    @Resource
    private OrderOfferDetailDao orderOfferDetailDao;


    @Resource
    private ConvertManager convertManager;

    @Override
    public CommonBOResult createOrder(OrderBORequest orderBORequest) {
        CommonBOResult commonBOResult = new CommonBOResult();
        CommodityOrder commodityOrder = convertManager.tran(orderBORequest, CommodityOrder.class);
        commodityOrder.setPlatform(OrderConstant.OrderPlatform.MMALPLATFORM);
        commodityOrder = this.assembleOrderInformation(commodityOrder);

        if (!this.createOrderCheapDetail(orderBORequest, commodityOrder.getOrderUniqueId()) ||
                !this.createOrderDetail(orderBORequest, commodityOrder.getOrderUniqueId())) {
            log.error("insert about order of detail error ...");
            return commonBOResult;
        }


        CommonResultPO result = orderDao.createOrder(commodityOrder);
        if (!result.isSuccess()) {
            log.error("create order error in createOrder ...");
            return commonBOResult;
        }

        ResultOrderServiceCodeUtil.resultSuccess(commonBOResult);
        return commonBOResult;
    }


    /**
     * 添加订单得优惠明细
     *
     * @param orderBORequest
     * @param orderUniqueId
     * @return
     */
    private boolean createOrderCheapDetail(OrderBORequest orderBORequest, String orderUniqueId) {
        if (StringUtils.isBlank(orderUniqueId)) {
            log.error("orderUniqueId is null or empty in createOrderCheapDetail...");
            return false;
        }

        if (orderBORequest == null) {
            log.error("orderBORequest is null in createOrderCheapDetail...");
            return false;
        }

        if (!CollectionUtils.isEmpty(orderBORequest.getOrderCheapDetailParamList())) {
            for (OrderCheapDetailParamBO orderCheapDetailParamBO : orderBORequest.getOrderCheapDetailParamList()) {
                CommodityOrderOfferDetail commodityOrderOfferDetail = new CommodityOrderOfferDetail();

                commodityOrderOfferDetail.setCheapDescription(orderCheapDetailParamBO.getCheapDescription());
                commodityOrderOfferDetail.setCheapMoney(orderCheapDetailParamBO.getCheapMoney());
                commodityOrderOfferDetail.setCreateTime(new Date());
                commodityOrderOfferDetail.setUpdateTime(new Date());
                commodityOrderOfferDetail.setOrderUniqueId(orderUniqueId);

                CommonResultPO commonResultPO = orderOfferDetailDao.createOrderOfferDetail(commodityOrderOfferDetail);
                if (!commonResultPO.isSuccess()) {
                    log.error("insert orderCheapDetail error ...");
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 添加订单得商品明细
     *
     * @param orderBORequest
     * @param orderUniqueId
     * @return
     */
    private boolean createOrderDetail(OrderBORequest orderBORequest, String orderUniqueId) {
        if (StringUtils.isBlank(orderUniqueId)) {
            log.error("orderUniqueId is null or empty in createOrderDetail...");
            return false;
        }

        if (orderBORequest == null) {
            log.error("orderBORequest is null in createOrderDetail...");
            return false;
        }

        if (CollectionUtils.isEmpty(orderBORequest.getOrderDetailParam())) {
            log.error("order not have any commodity in createOrderDetail...");
            return false;
        }

        for (OrderDetailParamBO orderDetailParamBO : orderBORequest.getOrderDetailParam()) {
            CommodityOrderDetail commodityOrderDetail = new CommodityOrderDetail();
            commodityOrderDetail.setCommodityCount(orderDetailParamBO.getCommodityCount());
            commodityOrderDetail.setCommodityName(orderDetailParamBO.getCommodityName());
            commodityOrderDetail.setCommodityUnitPrice(orderDetailParamBO.getCommodityUnitPrice());
            commodityOrderDetail.setCreateTime(new Date());
            commodityOrderDetail.setUpdateTime(new Date());
            commodityOrderDetail.setOrderUniqueId(orderUniqueId);
            CommonResultPO commonResultPO = orderDetailDao.createOrderDetail(commodityOrderDetail);
            if (!commonResultPO.isSuccess()) {
                log.error("insert orderDetail error ...");
                return false;
            }
        }

        return true;
    }

    /**
     * 拼装订单信息
     *
     * @param commodityOrder
     * @return
     */
    private CommodityOrder assembleOrderInformation(CommodityOrder commodityOrder) {
        /**
         * 生成订单号uuid
         */
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        log.info("create orderUniqueId is :" + uuid + " in AssembleOrderInformation ...");
        commodityOrder.setOrderUniqueId(uuid);
        commodityOrder.setCreateOrderTime(new Date());
        commodityOrder.setUpdateOrderTime(new Date());
        commodityOrder.setOrderStatus(OrderConstant.OrderStatusConstant.TOBEPAYORDER);
        String numberId = orderNumberManager.createNumber();
        if (StringUtils.isBlank(numberId)) {
            log.error("OrderNumber create error ...");
            return null;
        }
        commodityOrder.setOrderNumber(numberId);
        return commodityOrder;
    }


}
