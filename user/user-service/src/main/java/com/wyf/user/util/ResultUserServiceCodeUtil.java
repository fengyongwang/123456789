package com.wyf.user.util;

import com.wyf.bo.CommonBOResult;
import com.wyf.data.vo.result.CommonResultVO;
import com.wyf.util.ResultConstant;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
public class ResultUserServiceCodeUtil {

    /**
     * 返回结果success
     * @param result
     */
    public static void resultSuccess(CommonBOResult result) {
        result.setMessage(ResultConstant.MESSAGE.DEFAULT_SUCCESS_MESSAGE);
        result.setStatus(ResultConstant.CODE.SUCCESS);

    }

    /**
     * 返回结果未登录
     * @param result
     */
    public static void resultNoLogin(CommonBOResult result) {
        result.setMessage(ResultConstant.MESSAGE.DEFAULT_NOLONIN_MESSAGE);
        result.setStatus(ResultConstant.CODE.NOLOGIN);

    }



    /**
     * 返回结果失败
     * @param result
     */
    public static void resultError(CommonBOResult result) {
        result.setMessage(ResultConstant.MESSAGE.DEFAULT_ERROR_MESSAGE);
        result.setStatus(ResultConstant.CODE.ERROR);

    }


    /**
     * 返回结果缺少参数
     * @param result
     */
    public static void resultMissParam(CommonBOResult result) {
        result.setMessage(ResultConstant.MESSAGE.DEFAULT_MISS_PARAM_MESSAGE);
        result.setStatus(ResultConstant.CODE.ERROR);

    }

}
