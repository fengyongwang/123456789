package com.wyf.vo.user.result;

import com.wyf.data.vo.result.CommonResultVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/1
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
public class UserVOResult extends CommonResultVO {


    /**
     * token 信息
     */
    @ApiModelProperty(value = "token信息")
    private String token;

    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型")
    private Integer type;
}
