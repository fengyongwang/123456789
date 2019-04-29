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
public class UserLevelRequest extends CommonRequestPO {

    /**
     * id
     */
    private Integer id;

    /**
     * userId   用户id
     */
    private Integer userId;
    /**
     * 等级id
     */
    private Integer levelId;
    /**
     * 保持会员等级的截止时间，生成订单时产生
     */
    private Date deadlineTime;
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
