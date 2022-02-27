package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.PropertyManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface LoginDao {
    //封装login查询语句，指向Login.xml
    List<PropertyManager> login(String userName, String password);

}