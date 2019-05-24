package com.customer.util;

import com.merchant.data.vo.result.CommonResultVO;
import com.merchant.user.util.ResultConstant;

/**
 * Description: api 返回结果的工具类
 *
 * @author wangyf
 * @date 2019/4/29
 */
public class ResultCodeUtil {




    /**
     * 返回结果success
     * @param commonResultVO
     */
    public static void resultSuccess(CommonResultVO commonResultVO) {
        commonResultVO.setMessage(ResultConstant.MESSAGE.DEFAULT_SUCCESS_MESSAGE);
        commonResultVO.setCode(ResultConstant.CODE.SUCCESS);

    }

    /**
     * 返回结果未登录
     * @param commonResultVO
     */
    public static void resultNoLogin(CommonResultVO commonResultVO) {
        commonResultVO.setMessage(ResultConstant.MESSAGE.DEFAULT_NOLONIN_MESSAGE);
        commonResultVO.setCode(ResultConstant.CODE.NOLOGIN);

    }



    /**
     * 返回结果失败
     * @param commonResultVO
     */
    public static void resultError(CommonResultVO commonResultVO) {
        commonResultVO.setMessage(ResultConstant.MESSAGE.DEFAULT_ERROR_MESSAGE);
        commonResultVO.setCode(ResultConstant.CODE.ERROR);

    }


    /**
     * 返回结果缺少参数
     * @param commonResultVO
     */
    public static void resultMissParam(CommonResultVO commonResultVO) {
        commonResultVO.setMessage(ResultConstant.MESSAGE.DEFAULT_MISS_PARAM_MESSAGE);
        commonResultVO.setCode(ResultConstant.CODE.ERROR);

    }

}
