package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryPropertySetServicemanDTO;
import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryProprietorEntrustDTO;
import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryPropertySearchDTO;
import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryProprietorTrackListDTO;
import com.reecelu.pmsserver.dao.ExpressDeliveryDao;
import com.reecelu.pmsserver.entity.ExpressDelivery;
import com.reecelu.pmsserver.service.ExpressDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ExpressDeliveryServiceImpl implements ExpressDeliveryService {

    @Autowired
    ExpressDeliveryDao expressDeliveryDao;

    @Override
    //使用ExpressDeliveryDao中的searchExpressDelivery获取全部快递信息
    public List<ExpressDelivery> getExpressDeliveryInfo(DeliveryPropertySearchDTO deliveryPropertySearchDTO){
        String name= deliveryPropertySearchDTO.getName();
        String phone= deliveryPropertySearchDTO.getPhone();

        //pageNum对应SQl语句中Limit条件的Start值，pageSize对应SQL语句Limit条件的"步长"
        int pageNum=(deliveryPropertySearchDTO.getPageNum()-1)* deliveryPropertySearchDTO.getPageSize();
        int pageSize= deliveryPropertySearchDTO.getPageSize();

        List<ExpressDelivery> expressDelivery =expressDeliveryDao.searchExpressDelivery(name,phone,pageNum,pageSize);

        return expressDelivery;
    }

    //业主申请快递代领服务
    @Override
    public Integer entrustExpressDelivery(DeliveryProprietorEntrustDTO deliveryProprietorEntrustDTO){
        int proprietorId = deliveryProprietorEntrustDTO.getProprietorId();
        String deliveryType = deliveryProprietorEntrustDTO.getDeliveryType();
        String deliveryLocation = deliveryProprietorEntrustDTO.getDeliveryLocation();
        String deliveryCode  = deliveryProprietorEntrustDTO.getDeliveryCode();
        Timestamp createDate = Timestamp.valueOf(deliveryProprietorEntrustDTO.getCreateDate());
        String status = deliveryProprietorEntrustDTO.getStatus();

        return expressDeliveryDao.entrustExpressDelivery(proprietorId,deliveryType,deliveryLocation,deliveryCode,createDate,status);

    }

    //物业更新派件人
    @Override
    public Integer addExpressDeliveryServiceman(DeliveryPropertySetServicemanDTO deliveryPropertySetServicemanDTO){
        int id= deliveryPropertySetServicemanDTO.getId();
        String serviceman = deliveryPropertySetServicemanDTO.getServiceman();
        String status = deliveryPropertySetServicemanDTO.getStatus();

        return expressDeliveryDao.addDeliveryServiceman(id,serviceman,status);
    }

    //业主查询快递信息
    @Override
    public List<ExpressDelivery> getExpressDeliveryInfoProprietor(DeliveryProprietorTrackListDTO deliveryProprietorTrackListDTO){
        return expressDeliveryDao.trackExpressDeliveryProprietor(deliveryProprietorTrackListDTO.getProprietorId());
    }
}
