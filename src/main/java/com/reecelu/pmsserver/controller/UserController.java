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

    //新增和修改
    @PostMapping
    public Integer save(@RequestBody User user){
        return userService.save(user);
    }

    //查询所有
    @GetMapping
    public List<User> index(){
        List<User> all = userMapper.findAll();
        return all;
    }

    //删除
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userMapper.deleteById(id);
    }

    //分页查询实现
    //接口路径 ，/user/page
    @GetMapping("/page")
    public List<User> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        pageNum = (pageNum -1)*pageSize;
        return userMapper.selectPage(pageNum,pageSize);
    }
}
