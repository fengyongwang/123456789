package com.merchant.user.util;

import java.util.Random;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
public class UserUtil {

    /**
     * 随机码产生的数据范围
     */
    public static int CARDINALNUMBER=10;


    /**
     * 产生随机码
     * @param length
     * @return
     */
    public static String createRandomCode(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int a = random.nextInt(CARDINALNUMBER);

            stringBuilder.append(a);

        }

        return stringBuilder.toString();
    }

    /**
     * 验证码发送
     * @param phone
     * @param msg
     * @return
     */
    public static boolean sendMessage(String phone,String msg){

        /**
         * TODO   未做
         */
        return true;
    }

}
