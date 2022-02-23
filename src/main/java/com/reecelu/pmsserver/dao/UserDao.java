package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> getUserById();

}
