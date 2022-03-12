package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.AddDeliveryServicemanDTO;
import com.reecelu.pmsserver.controller.DTO.EntrustExpressDeliveryDTO;
import com.reecelu.pmsserver.controller.DTO.ExpressDeliveryPropertySearchDTO;
import com.reecelu.pmsserver.dao.ExpressDeliveryDao;
import com.reecelu.pmsserver.entity.ExpressDelivery;
import com.reecelu.pmsserver.service.ExpressDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    //业主申请快递代领服务
    @Override
    public Integer entrustExpressDelivery(EntrustExpressDeliveryDTO entrustExpressDeliveryDTO){
        int proprietorId = entrustExpressDeliveryDTO.getProprietorId();
        String deliveryType = entrustExpressDeliveryDTO.getDeliveryType();
        String deliveryLocation = entrustExpressDeliveryDTO.getDeliveryLocation();
        String deliveryCode  = entrustExpressDeliveryDTO.getDeliveryCode();
        Timestamp createDate = Timestamp.valueOf(entrustExpressDeliveryDTO.getCreateDate());
        String status = entrustExpressDeliveryDTO.getStatus();

        return expressDeliveryDao.entrustExpressDelivery(proprietorId,deliveryType,deliveryLocation,deliveryCode,createDate,status);

    }

    //物业更新派件人
    @Override
    public Integer addExpressDeliveryServiceman(AddDeliveryServicemanDTO addDeliveryServicemanDTO){
        int id=addDeliveryServicemanDTO.getId();
        String serviceman =addDeliveryServicemanDTO.getServiceman();

        return expressDeliveryDao.addDeliveryServiceman(id,serviceman);
    }
}
