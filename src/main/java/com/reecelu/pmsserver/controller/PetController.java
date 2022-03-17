package com.reecelu.pmsserver.controller;


import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.pet.PetPropertySearchDTO;
import com.reecelu.pmsserver.controller.DTO.pet.PetProprietorRegisterDTO;
import com.reecelu.pmsserver.controller.DTO.pet.PetProprietorSearchDTO;
import com.reecelu.pmsserver.dao.PetDao;
import com.reecelu.pmsserver.entity.Pet;
import com.reecelu.pmsserver.service.PetService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pms/pet")
@Resource
public class PetController {
    @Autowired
    PetService petService;

    @Autowired
    PetDao petDao;

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


    @ApiOperation(value = "propertySearchPet",notes = "物业查询宠物")  //swagger注释
    @PostMapping("/propertysearchpet")
    public Result propertySearchPet(@RequestBody PetPropertySearchDTO petProprietorRegisterDTO ){

       List<Pet> result = petService.propertySearchPet(petProprietorRegisterDTO);
       int total = petDao.propertySearchCount(petProprietorRegisterDTO.getName(),petProprietorRegisterDTO.getPhone());

        Map<String,Object> res=new HashMap<>();
        res.put("total",total);
        res.put("tableData",result);

        if(res!=null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"查询失败");
        }

    }


    @ApiOperation(value = "proprietorSearchPet",notes = "物业查询宠物")  //swagger注释
    @PostMapping("/proprietorsearchpet")
    public Result proprietorSearchPet(@RequestBody PetProprietorSearchDTO petProprietorSearchDTO){

        List<Pet> result = petService.proprietorSearchPet(petProprietorSearchDTO);

        if(result!=null){
            return Result.success(result);
        }else{
            return Result.error(Constants.CODE_600,"查询失败");
        }

    }
}
