package com.merchant.task.constant;

import com.merchant.task.bean.Shop;
import com.merchant.task.bean.ShopUpdate;
import com.merchant.task.bean.User;
import com.merchant.task.bean.UserUpdate;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/30
 */
public class TaskKafkaConstant {
    public static class Topic {


        public static final String TASK_TOPIC = "task_event";
    }


    public static class ClassMap{

        public static final Class INSERT_USER= User.class;

        public static final Class UPDATE_USER= UserUpdate.class;

        public static final Class INSERT_SHOP= Shop.class;

        public static final Class UPDATE_SHOP= ShopUpdate.class;
    }


    public static class Type{
        public static final String USER_INSERT="user_insert";

        public static final String USER_UPDATE="user_update";

        public static final String SHOP_INSERT="shop_insert";

        public static final String SHOP_UPDATE="shop_update";
    }

}
