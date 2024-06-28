package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.pet.*;
import com.reecelu.pmsserver.entity.Pet;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetService {

    Integer proprietorRegister(PetProprietorRegisterDTO petProprietorRegisterDTO);

    List<Pet> propertySearchPet(PetPropertySearchDTO petPropertySearchDTO);

    List<Pet> proprietorSearchPet(PetProprietorSearchDTO petProprietorSearchDTO);

    Integer proprietorSetPet(ProprietorSetPetInfoDTO proprietorSetPetInfoDTO);

    Integer proprietorApplyPetCare(PetProprietorApplyPetCareDTO petProprietorApplyPetCareDTO);
}
