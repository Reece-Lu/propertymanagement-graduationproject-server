package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.LoginDTO;
import com.reecelu.pmsserver.entity.PropertyManager;
import com.reecelu.pmsserver.entity.Proprietor;
import com.reecelu.pmsserver.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pms/login")
@Resource
public class LoginController {

    @Autowired
    LoginService loginService;

    // POST request - Property Management Login Validation
    @ApiOperation(value = "loginForPropertyManagement", notes = "Property management login validation")  // Swagger annotation
    @PostMapping("/propertymanagement")
    public Result loginForPropertyManagement(@RequestBody LoginDTO loginDTO){
        // Extract parameters from the request
        String userName = loginDTO.getUserName();
        String password = loginDTO.getPassword();

        // Using PropertyManager object to obtain the getPropertyManager result
        PropertyManager propertyManager = loginService.getPropertyManager(userName, password);
        // If the object propertyManager is empty, it implies no matching results in the database, otherwise login is successful
        if(propertyManager != null){
            return Result.success(propertyManager);
        } else {
            return Result.error(Constants.CODE_600, "Login failed");
        }

    }

    // POST request - Proprietor Login Validation
    @ApiOperation(value = "loginForProprietor", notes = "Proprietor login validation")  // Swagger annotation
    @PostMapping("/proprietor")
    public Result loginForProprietor(@RequestBody LoginDTO loginDTO){
        // Extract parameters from the request
        String userName = loginDTO.getUserName();
        String password = loginDTO.getPassword();

        // Using Proprietor object to obtain the getProprietor result
        Proprietor proprietor = loginService.getProprietor(userName, password);
        // If the object proprietor is empty, it implies no matching results in the database, otherwise login is successful
        if(proprietor != null){
            return Result.success(proprietor);
        } else {
            return Result.error(Constants.CODE_600, "Login failed");
        }

    }

}
