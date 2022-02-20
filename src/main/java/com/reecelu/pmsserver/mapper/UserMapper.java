package com.reecelu.pmsserver.mapper;

import com.reecelu.pmsserver.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


    @Select("select * from sys_user")
    List<User> findAll();

}
