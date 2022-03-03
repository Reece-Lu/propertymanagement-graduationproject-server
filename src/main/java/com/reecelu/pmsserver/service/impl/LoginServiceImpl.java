package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.dao.LoginDao;
import com.reecelu.pmsserver.entity.PropertyManager;
import com.reecelu.pmsserver.entity.Proprietor;
import com.reecelu.pmsserver.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    //使用LoginDao对象封装的数据库查询方法进行查询
    @Autowired
    LoginDao loginDao;

    //物业登陆校验函数,被DTO层调用，传入参数userName和password
    @Override
    public PropertyManager getPropertyManager(String userName, String password) {
        //创建PropertyManager对象List存放LoginDao层数据库查询结果
        List<PropertyManager> propertyManager = loginDao.loginForPropertyManagement(userName, password);
        //若List为空，则说明数据库查询无果，返回空；反之返回第一条数据；
        if (propertyManager.size() == 0) {
            return null;
        } else {
            return propertyManager.get(0);
        }
    }

    @Override
    public Proprietor getProprietor(String userName, String password){
        //创建PropertyManager对象List存放LoginDao层数据库查询结果
        List<Proprietor> Proprietor = loginDao.loginForProprietor(userName, password);
        //若List为空，则说明数据库查询无果，返回空；反之返回第一条数据；
        if (Proprietor.size() == 0) {
            return null;
        } else {
            return Proprietor.get(0);
        }
    }

}
