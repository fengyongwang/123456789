package com.merchant.user.po.request;

import com.merchant.data.po.request.CommonRequestPO;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/4
 */
@Data
public class TotalCommodityRequest extends CommonRequestPO {

    /**
     * 主键id
     */
    private Integer id;
    /**
     *商品分类名称
     */
    private String commodityTypeName;

    /**
     * 主键ids
     */
    private List<Integer>ids;
}
