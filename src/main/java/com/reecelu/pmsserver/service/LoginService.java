package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.entity.PropertyManager;
import com.reecelu.pmsserver.entity.Proprietor;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    //物业登陆校验函数,被DTO层调用，传入参数userName和password
    PropertyManager getPropertyManager(String userName,String password);

    //业主登陆校验函数,被DTO层调用，传入参数userName和password
    Proprietor getProprietor(String userName,String password);

}
