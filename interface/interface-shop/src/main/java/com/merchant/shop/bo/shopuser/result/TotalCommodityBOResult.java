package com.merchant.shop.bo.shopuser.result;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.shop.bo.shopuser.data.TotalCommodityBO;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/13
 */
@Data
public class TotalCommodityBOResult extends CommonBOResult {
    /**
     * 所有门类主营业务得类型集合
     */
    private List<TotalCommodityBO> totalCommodityList;

}
