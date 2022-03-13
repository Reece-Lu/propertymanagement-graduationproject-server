package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.AddDeliveryServicemanDTO;
import com.reecelu.pmsserver.controller.DTO.EntrustExpressDeliveryDTO;
import com.reecelu.pmsserver.controller.DTO.ExpressDeliveryPropertySearchDTO;
import com.reecelu.pmsserver.controller.DTO.TrackExpressDeliveryDTO;
import com.reecelu.pmsserver.entity.ExpressDelivery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpressDeliveryService {
    //使用ExpressDeliveryDao中的searchExpressDelivery获取全部快递信息
    List<ExpressDelivery> getExpressDeliveryInfo(ExpressDeliveryPropertySearchDTO expressDeliveryPropertySearchDTO);

    //业主申请快递代领服务
    Integer entrustExpressDelivery(EntrustExpressDeliveryDTO entrustExpressDeliveryDTO);

    //物业添加派件人
    Integer addExpressDeliveryServiceman(AddDeliveryServicemanDTO addDeliveryServicemanDTO);

    //业主查询快递信息
    List<ExpressDelivery> getExpressDeliveryInfoProprietor(TrackExpressDeliveryDTO trackExpressDeliveryDTO);
}
