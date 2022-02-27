package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.PropertyManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface LoginDao {

    List<PropertyManager> login(@Param("userName")String userName, @Param("password")String password);

}
