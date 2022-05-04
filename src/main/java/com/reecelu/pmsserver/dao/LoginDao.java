package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.PropertyManager;
import com.reecelu.pmsserver.entity.Proprietor;
import com.reecelu.pmsserver.entity.SMS;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginDao {
    //封装login查询语句，指向Login.xml for Property Management
    List<PropertyManager> loginForPropertyManagement(String userName, String password);

    //封装login查询语句，指向Login.xml for Proprietor /prə'praɪətə/
    List<Proprietor> loginForProprietor(String userName, String password);

    //检查手机号是否已经存在(在业主表中查)
    Integer whetherRegistered(String phone);

    //更新手机号验证码
    Integer UpdateCode(String phone, String code);

    //若为新号码，新增号码
    Integer newPhone(String phone, String code);

    //获取验证码
    List<SMS> getCode(String phone);

    //业主·注册账号
    Integer newProprietor(String userName ,String  password,String name ,String  title,String  email,String  phone,String  weChat,String  building,String  door,String  roleInFamily);

}