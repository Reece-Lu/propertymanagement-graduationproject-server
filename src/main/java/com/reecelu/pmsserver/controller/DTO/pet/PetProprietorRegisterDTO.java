package com.reecelu.pmsserver.controller.DTO.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetProprietorRegisterDTO {
    private int masterId;
    private String petName;
    private int age;
    private String createDate;
    private String species;
}
