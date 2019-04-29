package com.wyf.user.po.request;

import com.wyf.data.po.request.CommonRequestPO;
import lombok.Data;

import java.util.Date;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
@Data
public class LevelRequest extends CommonRequestPO {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 等级名称
     */
    private String levelName;
    /**
     * 等级备注
     */
    private String remarks;
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
    private String modifyBy;
    /**
     * 创建者
     */
    private String createBy;

}
