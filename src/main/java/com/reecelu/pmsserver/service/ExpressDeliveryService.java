package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.ExpressDeliveryPropertySearchDTO;
import com.reecelu.pmsserver.entity.ExpressDelivery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpressDeliveryService {
    //使用ExpressDeliveryDao中的searchExpressDelivery获取全部快递信息
    List<ExpressDelivery> getExpressDeliveryInfo(ExpressDeliveryPropertySearchDTO expressDeliveryPropertySearchDTO);
}
