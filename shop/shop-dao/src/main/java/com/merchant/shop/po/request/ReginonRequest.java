package com.merchant.shop.po.request;

import com.merchant.data.po.request.CommonRequestPO;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/5
 */
@Data
public class ReginonRequest extends CommonRequestPO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 地区级别 1：省级别，2：市级别，3：区级别
     */
    private Integer regionLevel;

    /**
     * 地区父code
     */
    private String  regionParentId;

}
