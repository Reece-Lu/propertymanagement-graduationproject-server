package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.ExpressDeliveryPropertySearchDTO;
import com.reecelu.pmsserver.dao.ExpressDeliveryDao;
import com.reecelu.pmsserver.entity.ExpressDelivery;
import com.reecelu.pmsserver.service.ExpressDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpressDeliveryServiceImpl implements ExpressDeliveryService {

    @Autowired
    ExpressDeliveryDao expressDeliveryDao;

    @Override
    //使用ExpressDeliveryDao中的searchExpressDelivery获取全部快递信息
    public List<ExpressDelivery> getExpressDeliveryInfo(ExpressDeliveryPropertySearchDTO expressDeliveryPropertySearchDTO){
        String name=expressDeliveryPropertySearchDTO.getName();
        String phone=expressDeliveryPropertySearchDTO.getPhone();

        //pageNum对应SQl语句中Limit条件的Start值，pageSize对应SQL语句Limit条件的"步长"
        int pageNum=(expressDeliveryPropertySearchDTO.getPageNum()-1)* expressDeliveryPropertySearchDTO.getPageSize();
        int pageSize=expressDeliveryPropertySearchDTO.getPageSize();

        List<ExpressDelivery> expressDelivery =expressDeliveryDao.searchExpressDelivery(name,phone,pageNum,pageSize);

        return expressDelivery;
    }
}
