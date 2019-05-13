package com.merchant.shop.manage.shopuser;

import com.merchant.shop.bo.shopuser.request.TotalCommodityBORequest;
import com.merchant.shop.bo.shopuser.result.TotalCommodityBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/13
 */
public interface TotalCommodityManager {

    /**
     * 查询所有得门店类型总和
     * @param totalCommodityBORequest
     * @return
     */
    TotalCommodityBOResult queryTotalCommodity(TotalCommodityBORequest totalCommodityBORequest);

}
