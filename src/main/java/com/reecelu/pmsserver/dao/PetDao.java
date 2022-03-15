package com.reecelu.pmsserver.dao;

import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

@Mapper
public interface PetDao {

    //登记宠物
    Integer registerPet(int masterId, String name, int age, Timestamp createDate,String species);
}
