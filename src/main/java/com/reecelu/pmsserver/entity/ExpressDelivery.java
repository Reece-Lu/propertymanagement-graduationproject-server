package com.reecelu.pmsserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpressDelivery extends Proprietor{
    private int id;
    private int proprietorId;
    private String deliveryCode;
    private String deliveryType;
    private String deliveryLocation;
    private String serviceman;
    private String createDate;
}
