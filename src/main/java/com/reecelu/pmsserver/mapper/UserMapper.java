package com.reecelu.pmsserver.mapper;

import com.reecelu.pmsserver.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {


    @Select("select * from sys_user")
    List<User> findAll();

    @Insert("INSERT into sys_user(username,password,nickname,email,phone,address)VALUES" +
            "(#{username},#{password},#{nickname},#{email},#{phone},#{address})")
    int insert(User user);

    @Update("update sys_user set username=#{username},password=#{password},nickname=#{nickname},email=#{email}" +
            ",phone=#{phone},address=#{address} where id =#{id}")
    int update(User user);
}
