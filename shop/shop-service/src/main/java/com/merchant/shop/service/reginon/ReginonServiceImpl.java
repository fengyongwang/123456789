package com.merchant.shop.service.reginon;

import com.merchant.shop.bo.reginon.request.ReginonBORequest;
import com.merchant.shop.bo.reginon.result.ReginonBOResult;
import com.merchant.shop.manage.reginon.ReginonManage;
import com.merchant.shop.service.ReginonService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/8
 */
@Log4j
@Service
@com.alibaba.dubbo.config.annotation.Service
public class ReginonServiceImpl implements ReginonService {

    @Resource
    private ReginonManage reginonManage;


    @Override
    public ReginonBOResult queryReginonByRequest(ReginonBORequest reginonBORequest) {

        return this.reginonManage.queryReginonByRequest(reginonBORequest);
    }
}
