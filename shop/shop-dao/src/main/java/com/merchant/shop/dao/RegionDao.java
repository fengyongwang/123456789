package com.merchant.shop.dao;

import com.merchant.shop.po.data.Reginon;
import com.merchant.shop.po.request.ReginonRequest;
import com.merchant.shop.po.result.ReginonResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/5
 */
public interface RegionDao {

    /**
     * 根据条件查省市区信息
     * @param request
     * @return
     */
    ReginonResult queryRegionByRequest(ReginonRequest request);


    /**
     * 添加一个地区信息
     * @param region
     * @return
     */
    ReginonResult insertRegion(Reginon region);
}
