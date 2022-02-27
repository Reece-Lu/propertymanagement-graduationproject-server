package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.LoginDTO;
import com.reecelu.pmsserver.entity.PropertyManager;
import com.reecelu.pmsserver.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pms/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @ApiOperation(value = "login",notes = "登录功能")  //swagger注释

    @PostMapping()
    public Result login(@RequestBody LoginDTO loginDTO){
        String userName=loginDTO.getUserName();
        String password=loginDTO.getPassword();

        PropertyManager propertyManager=loginService.getPropertyManager(userName,password);
        if(propertyManager!=null){
            return Result.success(propertyManager);
        }else{
            return Result.error(Constants.CODE_600,"登录失败");
        }

    }

}
