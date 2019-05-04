package com.merchant.user.manager.user;

import com.merchant.bo.CommonBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
public interface UserManager {


    /**
     * 生成图片验证码存入redis
     * @param userName
     * @return
     */
    CommonBOResult createImageCode(String userName);

}
