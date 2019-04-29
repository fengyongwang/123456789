package com.wyf.user.po.request;

import com.wyf.data.po.request.CommonRequestPO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.Date;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
@Data
public class LevelToolRequest extends CommonRequestPO {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 等级id
     */
    private Integer levelId;
    /**
     * 工具id
     */
    private Integer toolId;
    /**
     * 修改时间
     */
    private Date lastModifyTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改者
     */
    private Integer modifyBy;
    /**
     * 创建者
     */
    private Integer createBy;

}
