package com.reecelu.pmsserver.controller.DTO.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertySearchCarDTO {
    private String name;
    private String phone;
    private int pageNum;
    private int pageSize;
}
