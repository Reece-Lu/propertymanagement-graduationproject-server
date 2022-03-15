package com.reecelu.pmsserver.controller;


import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.pet.PetProprietorRegisterDTO;
import com.reecelu.pmsserver.controller.DTO.proprietorArchives.ProprietorGetSelfInfoDTO;
import com.reecelu.pmsserver.dao.PetDao;
import com.reecelu.pmsserver.dao.ProprietorInfoDao;
import com.reecelu.pmsserver.entity.Proprietor;
import com.reecelu.pmsserver.service.PetService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pms/pet")
@Resource
public class PetController {
    @Autowired
    PetService petService;

    @ApiOperation(value = "proprietorRegisterPet",notes = "业主登记宠物")  //swagger注释
    @PostMapping("/proprietorregisterPet")
    public Result proprietorRegisterPet(@RequestBody PetProprietorRegisterDTO petProprietorRegisterDTO){

        //使用 int 类型的对象获取 proprietorRegister 返回结果
        Integer res = petService.proprietorRegister(petProprietorRegisterDTO);
        //proprietor，反正登陆成功
        if(res!=0){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"登记失败咯");
        }

    }
}
