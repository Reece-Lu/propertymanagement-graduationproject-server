package com.reecelu.pmsserver.controller.DTO.Car;

/*
 * 业主·修改车辆信息
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarProprietorChangeCarInfoDTO {
    private int id;
    private String licensePlate;
    private String parkingSpace;
    private String colour;
}
