package com.merchant.order.constant.order;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/24
 */
public class OrderConstant {


    /**
     * 订单状态
     */
    public static final class OrderStatusConstant {

        /**
         * 待支付
         */
        public static final String TOBEPAYORDER = "to_be_pay_order";

        /**
         * 已支付 未发货
         */
        public static final String PAYEDORDERNOTSHIP = "payed_order_not_ship";

        /**
         * 已发货，配送中    TODO没有接通物流数据
         */
        public static final String SHIPEDDISTRIBUTION = "shiped_distribution";


        /**
         * 已完成
         */
        public static final String ORDERCOMPLETE = "order_complete";

    }

    /**
     * 订单来源类型
     */
    public static final class OrderPlatform{

        /**
         * mmal商城
         */
        public static final String MMALPLATFORM="mmal";

    }



}
