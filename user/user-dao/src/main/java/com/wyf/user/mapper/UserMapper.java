package com.wyf.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyf.user.po.data.User;
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
