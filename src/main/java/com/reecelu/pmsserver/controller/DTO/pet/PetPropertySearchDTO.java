package com.reecelu.pmsserver.controller.DTO.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetPropertySearchDTO {
    private String name;
    private String phone;
    private int pageNum;
    private int pageSize;
}
