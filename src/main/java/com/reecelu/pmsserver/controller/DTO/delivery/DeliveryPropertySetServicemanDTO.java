package com.reecelu.pmsserver.controller.DTO.delivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryPropertySetServicemanDTO {
    private int id;
    private String status;
    private String serviceman;
}
