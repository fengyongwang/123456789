package com.merchant.user.manage;

import com.merchant.task.bean.User;
import com.merchant.user.bo.user.request.UserBORequest;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/22
 */
public interface MessageManagerDemo {

    /**
     * 发送消息到kafka
     * @param message
     */
    void sendMessage(String message);


    /**
     * UserBORequest的javaBean转成Insert类型的json格式
     * @param userBORequest
     * @return
     */
    String dealInsertBeanToJson(UserBORequest userBORequest);


    /**
     * UserBORequest的javaBean转成Update 类型的json格式
     * @param userBORequest
     * @return
     */
    String dealUpdateBeanToJson(UserBORequest userBORequest);

}
