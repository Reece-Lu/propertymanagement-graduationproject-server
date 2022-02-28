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

import javax.annotation.Resource;

@RestController
@RequestMapping("/pms/login")
@Resource
public class LoginController {

    @Autowired
    LoginService loginService;

    @ApiOperation(value = "login",notes = "登录功能")  //swagger注释

    //Post请求-登陆验证
    @PostMapping()
    public Result login(@RequestBody LoginDTO loginDTO){
        //取出请求中的参数
        String userName=loginDTO.getUserName();
        String password=loginDTO.getPassword();

        //使用PropertyManager(物业管理员)类型的对象获取getPropertyManager返回结果
        PropertyManager propertyManager=loginService.getPropertyManager(userName,password);
        //若对象propertyManager为空则表明数据库为匹配到结果，反正登陆成功
        if(propertyManager!=null){
            return Result.success(propertyManager);
        }else{
            return Result.error(Constants.CODE_600,"登录失败");
        }

    }

}
