package com.merchant.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.merchant.shop.po.data.Commodity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/4
 */
@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {
}
