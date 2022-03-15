package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.pet.PetProprietorRegisterDTO;
import com.reecelu.pmsserver.dao.PetDao;
import com.reecelu.pmsserver.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetDao petDao;

    public Integer proprietorRegister(PetProprietorRegisterDTO petProprietorRegisterDTO){
        int masterId = petProprietorRegisterDTO.getMasterId();
        String name = petProprietorRegisterDTO.getName();
        int age =petProprietorRegisterDTO.getAge();
        Timestamp createDate = Timestamp.valueOf(petProprietorRegisterDTO.getCreateDate());
        String species =petProprietorRegisterDTO.getSpecies();

        return petDao.registerPet(masterId,name,age,createDate,species);
    }

}
