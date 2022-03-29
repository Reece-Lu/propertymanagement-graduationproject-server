package com.reecelu.pmsserver.controller.DTO.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetProprietorApplyPetCareDTO {
    private int masterId;
    private int petId;
    private String startTime;
    private String endTime;
}
