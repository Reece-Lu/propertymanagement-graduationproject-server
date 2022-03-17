package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.Pet;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface PetDao {

    //登记宠物
    Integer registerPet(int masterId, String petName, int age, Timestamp createDate,String species);

    List<Pet> propertySearch(String name,String phone , int pageNum,int pageSize);

    Integer propertySearchCount(String name,String phone);

    List<Pet> proprietorSearchPet(int masterId);
}
