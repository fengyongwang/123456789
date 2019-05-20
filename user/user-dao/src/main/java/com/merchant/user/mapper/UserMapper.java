package com.merchant.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.merchant.user.po.data.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/30
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
