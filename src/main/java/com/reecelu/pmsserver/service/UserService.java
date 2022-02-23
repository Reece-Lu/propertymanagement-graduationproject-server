package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.entity.User;
import com.reecelu.pmsserver.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getUserById();
}
