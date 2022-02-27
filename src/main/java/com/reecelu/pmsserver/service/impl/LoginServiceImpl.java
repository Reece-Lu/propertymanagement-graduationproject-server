package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.dao.LoginDao;
import com.reecelu.pmsserver.entity.PropertyManager;
import com.reecelu.pmsserver.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;


    @Override
    public PropertyManager getPropertyManager(String userName, String password) {
        List<PropertyManager> propertyManager = loginDao.login(userName, password);
        if (propertyManager.size() == 0) {
            return null;
        } else {
            return propertyManager.get(0);
        }
    }
}
