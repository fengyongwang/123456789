package com.merchant.shop.bo.shopuser.request;

import com.merchant.user.bo.CommonBORequest;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/13
 */
@Data
public class TotalCommodityBORequest extends CommonBORequest {


    /**
     * 主键id
     */
    private Integer id;
    /**
     * 商品分类名称
     */
    private String commodityTypeName;

    /**
     * 主键ids
     */
    private List<Integer> ids;

}
