package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.ChangeProprietorInfoDTO;
import com.reecelu.pmsserver.controller.DTO.ProprietorInfoDTO;
import com.reecelu.pmsserver.entity.Proprietor;
import com.reecelu.pmsserver.service.ProprietorInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pms/proprietorinfo")
@Resource
public class ProprietorInfoController {

    @Autowired
    ProprietorInfoService proprietorInfoService;

    @ApiOperation(value = "getProprietorInfo",notes = "获取业主个人信息")  //swagger注释
    @PostMapping("/getproprietorinfo")
    public Result getProprietorInfo(@RequestBody ProprietorInfoDTO proprietorInfoDTO){
        //取出请求中的参数
        int id=proprietorInfoDTO.getId();

        //使用 proprietor(业主)类型的对象获取 getProprietorInfo 返回结果
        Proprietor proprietor=proprietorInfoService.getProprietorInfo(id);
        //proprietor，反正登陆成功
        if(proprietor!=null){
            return Result.success(proprietor);
        }else{
            return Result.error(Constants.CODE_600,"查无此人");
        }

    }

    //业主信息修改功能，传入值：账号ID、属性码attribute、修改值value
    @ApiOperation(value = "changeInfo",notes = "修改业主个人信息，传入值：账号ID、属性码attribute、修改值value")  //swagger注释
    @PostMapping("/changeInfo")
    public Result changeInfo(@RequestBody ChangeProprietorInfoDTO changeProprietorInfoDTO){
        //取出请求中的参数
        int id=changeProprietorInfoDTO.getId();
        int attribute =changeProprietorInfoDTO.getAttribute();
        String value=changeProprietorInfoDTO.getValue();
        System.out.println(attribute);

        //使用 feedback类型的对象获取 getProprietorInfo 返回结果
        int feedback=proprietorInfoService.changeProprietorInfo(id,attribute,value);
        //feedback为1，则说明信息修改成功
        if(feedback==1){
            return Result.success(feedback);
        }else{
            return Result.error(Constants.CODE_600,"修改失败");
        }

    }



}
