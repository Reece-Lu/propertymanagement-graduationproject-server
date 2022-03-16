package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.pet.PetPropertySearchDTO;
import com.reecelu.pmsserver.controller.DTO.pet.PetProprietorRegisterDTO;
import com.reecelu.pmsserver.entity.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetService {

    Integer proprietorRegister(PetProprietorRegisterDTO petProprietorRegisterDTO);

    List<Pet> propertySearchPet(PetPropertySearchDTO petPropertySearchDTO);

    String getSysYear();
}
