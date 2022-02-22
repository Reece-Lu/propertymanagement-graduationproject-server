package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.entity.User;
import com.reecelu.pmsserver.mapper.UserMapper;
import com.reecelu.pmsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @PostMapping
    public Integer save(@RequestBody User user){
        return userMapper.insert(user);
    }


    @GetMapping()
    public List<User> index(){
        List<User> all= userMapper.findAll();
        return userMapper.findAll();
    }
}
