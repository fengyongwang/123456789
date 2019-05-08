package com.merchant.shop.manage.reginon;

import com.merchant.shop.bo.request.ReginonBORequest;
import com.merchant.shop.bo.result.ReginonBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/8
 */
public interface ReginonManage {


    /**
     * 根据父地区得code查询所有得子地区
     * @param reginonBORequest
     * @return
     */
    ReginonBOResult queryReginonByRequest(ReginonBORequest reginonBORequest);

}
