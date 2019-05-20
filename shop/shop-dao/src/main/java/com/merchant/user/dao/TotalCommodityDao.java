package com.merchant.user.dao;

import com.merchant.user.po.data.TotalCommodity;
import com.merchant.user.po.request.TotalCommodityRequest;
import com.merchant.user.po.result.TotalCommodityResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/4
 */
public interface TotalCommodityDao {

    /**
     * 增加一个商品分类
     * @param totalCommodity
     * @return
     */
    TotalCommodityResult insert(TotalCommodity totalCommodity);

    /**
     * 根据条件查询商品分类
     * @param request
     * @return
     */
    TotalCommodityResult queryByRequest(TotalCommodityRequest request);
}
