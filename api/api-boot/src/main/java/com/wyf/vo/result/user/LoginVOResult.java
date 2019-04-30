package com.wyf.vo.result.user;

import com.wyf.data.vo.result.CommonResultVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel
public class LoginVOResult extends CommonResultVO {


    /**
     * token 信息
     */
    private String token;

}
