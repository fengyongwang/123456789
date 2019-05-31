package com.merchant.task.constant;

import com.merchant.task.bean.User;

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

        public static final Class INSERT_SHOP= User.class;

    }


    public static class Type{
        public static final String USER_INSERT="user_insert";
    }

}
