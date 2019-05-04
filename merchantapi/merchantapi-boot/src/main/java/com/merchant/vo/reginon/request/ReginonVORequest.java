package com.merchant.vo.reginon.request;

import com.merchant.data.vo.request.CommonRequestVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/4
 */
@Data
@ApiModel
public class ReginonVORequest extends CommonRequestVO {

    /**
     * 父级区域id
     */
    private Integer parentId;




}
