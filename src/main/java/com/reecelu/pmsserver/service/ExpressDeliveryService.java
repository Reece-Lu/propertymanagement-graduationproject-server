package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryPropertySetServicemanDTO;
import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryProprietorEntrustDTO;
import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryPropertySearchDTO;
import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryProprietorTrackListDTO;
import com.reecelu.pmsserver.entity.ExpressDelivery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpressDeliveryService {
    //使用ExpressDeliveryDao中的searchExpressDelivery获取全部快递信息
    List<ExpressDelivery> getExpressDeliveryInfo(DeliveryPropertySearchDTO deliveryPropertySearchDTO);

    //业主申请快递代领服务
    Integer entrustExpressDelivery(DeliveryProprietorEntrustDTO deliveryProprietorEntrustDTO);

    //物业添加派件人
    Integer addExpressDeliveryServiceman(DeliveryPropertySetServicemanDTO deliveryPropertySetServicemanDTO);

    //业主查询快递信息
    List<ExpressDelivery> getExpressDeliveryInfoProprietor(DeliveryProprietorTrackListDTO deliveryProprietorTrackListDTO);
}
