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
public class AuthorizationRequest extends CommonRequestPO {

    /**
     * id
     */
    private Integer id;
    /**
     * 授权来源类型
     */
    private String type;
    /**
     * 授权方提供的open_iD
     */
    private String openId;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String avatarUrl;
    /**
     * userID
     */
    private Integer userId;
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
