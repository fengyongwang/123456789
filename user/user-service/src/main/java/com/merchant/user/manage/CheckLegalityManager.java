package com.merchant.user.manage;

import com.merchant.user.bo.CommonBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/21
 */
public interface CheckLegalityManager {

    /**
     * 校验用户名或者手机号是否已经存在
     * @param name
     * @param phone
     * @return
     */
    CommonBOResult checkNameOrPhone(String name,String phone);

}
