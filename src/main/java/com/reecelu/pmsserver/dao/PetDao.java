package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.Pet;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface PetDao {

    //登记宠物
    Integer registerPet(int masterId, String petName, int age, Timestamp createDate,String species);

    //物业查询宠物档案
    List<Pet> propertySearch(String name,String phone , int pageNum,int pageSize);

    //统计物业查找宠物档案数据条数
    Integer propertySearchCount(String name,String phone);

    //业主查找宠物
    List<Pet> proprietorSearchPet(int masterId);

    //业主修改宠物信息
    Integer proprietorSetPetInfo(int id, String petName , int age , Timestamp createDate ,String species);

}
