package com.merchant.user.bo.token.request;

import com.merchant.user.bo.CommonBORequest;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/10
 */
@Data
public class TokenBORequest extends CommonBORequest {


    private static final long serialVersionUID = -6485696882312527142L;

    /**
     * token信息
     */
    private String token;
}
