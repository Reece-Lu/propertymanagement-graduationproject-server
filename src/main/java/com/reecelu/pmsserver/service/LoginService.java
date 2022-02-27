package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.entity.PropertyManager;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    PropertyManager getPropertyManager(String userName,String password);
}
