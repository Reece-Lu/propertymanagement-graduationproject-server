package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.Proprietor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProprietorInfoDao {
    //业主信息查询功能
    List<Proprietor> SearchProprietorInfo(int id);

    //业主信息修改功能
    Integer updateName(int id, String value);
    Integer updateTitle(int id, String value);
    Integer updatePhone(int id, String value);
    Integer updateEmail(int id, String value);
    Integer updateWeChat(int id, String value);
    Integer updateDoor(int id, String value);
    Integer updateBuilding(int id, String value);
    Integer updateEoleInFamily(int id, String value);


}
