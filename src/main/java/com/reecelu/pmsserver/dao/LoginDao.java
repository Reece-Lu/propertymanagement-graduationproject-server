package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.PropertyManager;
import com.reecelu.pmsserver.entity.Proprietor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface LoginDao {
    //封装login查询语句，指向Login.xml for Property Management
    List<PropertyManager> loginForPropertyManagement(String userName, String password);

    //封装login查询语句，指向Login.xml for Proprietor /prə'praɪətə/
    List<Proprietor> loginForProprietor(String userName, String password);
}