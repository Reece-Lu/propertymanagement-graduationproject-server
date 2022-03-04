package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
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

}
