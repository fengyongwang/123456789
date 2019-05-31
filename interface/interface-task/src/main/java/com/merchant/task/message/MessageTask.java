package com.merchant.task.message;

import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/30
 */
@Data
public class MessageTask {

    /**
     * 处理事件得类型  即过来得是个什么事件
     */
    private String type;

    /**
     * 需要处理得消息
     *  数组结构得json数据
     */
    private String msg;

}
