package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.pet.PetProprietorRegisterDTO;
import org.springframework.stereotype.Service;

@Service
public interface PetService {

    Integer proprietorRegister(PetProprietorRegisterDTO petProprietorRegisterDTO);
}
