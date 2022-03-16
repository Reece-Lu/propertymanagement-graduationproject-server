package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.pet.PetPropertySearchDTO;
import com.reecelu.pmsserver.controller.DTO.pet.PetProprietorRegisterDTO;
import com.reecelu.pmsserver.dao.PetDao;
import com.reecelu.pmsserver.entity.Pet;
import com.reecelu.pmsserver.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetDao petDao;

    public Integer proprietorRegister(PetProprietorRegisterDTO petProprietorRegisterDTO){
        int masterId = petProprietorRegisterDTO.getMasterId();
        String petName = petProprietorRegisterDTO.getPetName();
        int age =petProprietorRegisterDTO.getAge();
        Timestamp createDate = Timestamp.valueOf(petProprietorRegisterDTO.getCreateDate());
        String species =petProprietorRegisterDTO.getSpecies();

        return petDao.registerPet(masterId,petName,age,createDate,species);
    }

    public List<Pet> propertySearchPet(PetPropertySearchDTO petPropertySearchDTO){
        String name = petPropertySearchDTO.getName();
        String phone = petPropertySearchDTO.getPhone();
        //pageNum对应SQl语句中Limit条件的Start值，pageSize对应SQL语句Limit条件的"步长"
        int pageNum=(petPropertySearchDTO.getPageNum()-1)* petPropertySearchDTO.getPageSize();
        int pageSize= petPropertySearchDTO.getPageSize();

        List<Pet> result = petDao.propertySearch(name,phone,pageNum,pageSize);

        for(int i =0;i<result.size();i++){
            int age = result.get(i).getAge();
            String createYear = result.get(i).getCreateDate().substring(0,4);
            String rightYear = getSysYear();
            age = Integer.parseInt(rightYear) - Integer.parseInt(createYear) + age;
            result.set(i,result.get(i)).setAge(age);
        }
        return result;
    }


    public String getSysYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return year;
    }

}
