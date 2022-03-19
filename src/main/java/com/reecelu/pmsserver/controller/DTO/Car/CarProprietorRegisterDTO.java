package com.reecelu.pmsserver.controller.DTO.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 业主·登记车辆
* */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarProprietorRegisterDTO {
    private int masterId;
    private String licensePlate;
    private String parkingSpace;
    private String colour;
}
