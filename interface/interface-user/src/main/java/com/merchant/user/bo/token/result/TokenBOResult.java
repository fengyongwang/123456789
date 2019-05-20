package com.merchant.user.bo.token.result;

import com.merchant.user.bo.CommonBOResult;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/10
 */
@Data
public class TokenBOResult extends CommonBOResult {
    private static final long serialVersionUID = -5511855625239259008L;

    /**
     * 店家id
     */
    private Integer id;
    /**
     * 店家手机号码
     */
    private String phone;
}
