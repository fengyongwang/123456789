package com.merchant.user.manage;

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
     * UserBORequest的javaBean转成json格式
     * @param userBORequest
     * @return
     */
    String dealBeanToJson(UserBORequest userBORequest);
}
