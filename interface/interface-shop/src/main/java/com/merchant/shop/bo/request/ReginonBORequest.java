package com.merchant.shop.bo.request;

import com.merchant.bo.CommonBORequest;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/8
 */
@Data
public class ReginonBORequest extends CommonBORequest {

    /**
     * 地区父code
     */
    private String regionParentId;
    ;


}
