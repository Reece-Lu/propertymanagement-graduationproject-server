package com.reecelu.pmsserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetCare extends Pet{
    private int id;
    private int masterId;
    private int petId;
    private String startTime;
    private String endTime;
}
