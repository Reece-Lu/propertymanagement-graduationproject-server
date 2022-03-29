package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.pet.*;
import com.reecelu.pmsserver.dao.PetDao;
import com.reecelu.pmsserver.entity.Pet;
import com.reecelu.pmsserver.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    PetDao petDao;
    
    /*
    * 业主添加宠物
    * */
    public Integer proprietorRegister(PetProprietorRegisterDTO petProprietorRegisterDTO){
        int masterId = petProprietorRegisterDTO.getMasterId();
        String petName = petProprietorRegisterDTO.getPetName();
        int age =petProprietorRegisterDTO.getAge();
        Timestamp createDate = Timestamp.valueOf(petProprietorRegisterDTO.getCreateDate());
        String species =petProprietorRegisterDTO.getSpecies();

        return petDao.registerPet(masterId,petName,age,createDate,species);
    }

    /*
    * 物业查询宠物档案
    * */
    public List<Pet> propertySearchPet(PetPropertySearchDTO petPropertySearchDTO){
        String name = petPropertySearchDTO.getName();
        String phone = petPropertySearchDTO.getPhone();
        //pageNum对应SQl语句中Limit条件的Start值，pageSize对应SQL语句Limit条件的"步长"
        int pageNum=(petPropertySearchDTO.getPageNum()-1)* petPropertySearchDTO.getPageSize();
        int pageSize= petPropertySearchDTO.getPageSize();

        List<Pet> result = petDao.propertySearch(name,phone,pageNum,pageSize);

        return calculatePetAge(result);
    }

    /*
    * 计算宠物年龄
    * */
    public List<Pet> calculatePetAge(List<Pet> result) {
        for(int i =0;i<result.size();i++){
            int age = result.get(i).getAge();
            String createYear = result.get(i).getCreateDate().substring(0,4);
            Calendar date = Calendar.getInstance();
            String rightYear = String.valueOf(date.get(Calendar.YEAR));
            age = Integer.parseInt(rightYear) - Integer.parseInt(createYear) + age;
            result.set(i,result.get(i)).setAge(age);
        }
        return result;
    }

    /*
    * 业主主页展示所属宠物
    * */
    public List<Pet> proprietorSearchPet(PetProprietorSearchDTO petProprietorSearchDTO){
        List<Pet> result =  petDao.proprietorSearchPet(petProprietorSearchDTO.getMasterId());
        return calculatePetAge(result);
    }

    /*
    * 业主修改宠物信息
    * */
    public Integer proprietorSetPet(ProprietorSetPetInfoDTO proprietorSetPetInfoDTO){
        int id = proprietorSetPetInfoDTO.getId();
        String petName = proprietorSetPetInfoDTO.getPetName();
        int age =proprietorSetPetInfoDTO.getAge();
        Timestamp createDate = Timestamp.valueOf(proprietorSetPetInfoDTO.getCreateDate());
        String species =proprietorSetPetInfoDTO.getSpecies();

        return petDao.proprietorSetPetInfo(id, petName , age , createDate , species);
    }

    /*
    * 业主申请宠物寄养
    * */
    public Integer proprietorApplyPetCare(PetProprietorApplyPetCareDTO petProprietorApplyPetCareDTO){
        int masterId = petProprietorApplyPetCareDTO.getMasterId();
        int petId = petProprietorApplyPetCareDTO.getPetId();
        Timestamp startTime = Timestamp.valueOf(petProprietorApplyPetCareDTO.getStartTime());
        Timestamp endTime = Timestamp.valueOf(petProprietorApplyPetCareDTO.getEndTime());

        return petDao.proprietorApplyPetCare( masterId,petId,startTime,endTime);
    }
}
