package com.merchant.shop.dao;

import com.merchant.shop.po.data.Region;
import com.merchant.shop.po.request.RegionRequest;
import com.merchant.shop.po.result.RegionResult;

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
    RegionResult queryRegionByRequest(RegionRequest request);


    /**
     * 添加一个地区信息
     * @param region
     * @return
     */
    RegionResult insertRegion(Region region);
}
