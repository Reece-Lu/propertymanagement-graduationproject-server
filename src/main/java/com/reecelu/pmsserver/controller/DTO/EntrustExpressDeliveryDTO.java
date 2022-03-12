package com.reecelu.pmsserver.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

/**
 * 创建数据传输对象,业主申请快递代领
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntrustExpressDeliveryDTO {
    private int proprietorId;
    private String deliveryType;
    private String deliveryLocation;
    private String deliveryCode;
    private String createDate;
    private String status;
}
