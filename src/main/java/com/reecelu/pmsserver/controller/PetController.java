package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.pet.PetPropertySearchDTO;
import com.reecelu.pmsserver.controller.DTO.pet.PetProprietorRegisterDTO;
import com.reecelu.pmsserver.controller.DTO.pet.PetProprietorSearchDTO;
import com.reecelu.pmsserver.controller.DTO.pet.ProprietorSetPetInfoDTO;
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

    @ApiOperation(value = "proprietorRegisterPet", notes = "Proprietor registers a pet")  // Swagger annotation
    @PostMapping("/proprietorregisterPet")
    public Result proprietorRegisterPet(@RequestBody PetProprietorRegisterDTO petProprietorRegisterDTO){

        // Use integer type object to get proprietorRegister result
        Integer res = petService.proprietorRegister(petProprietorRegisterDTO);
        // If proprietor registration is successful
        if(res != 0){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"Registration failed");
        }

    }

    @ApiOperation(value = "propertySearchPet", notes = "Property searches for pets")  // Swagger annotation
    @PostMapping("/propertysearchpet")
    public Result propertySearchPet(@RequestBody PetPropertySearchDTO petPropertySearchDTO){

        List<Pet> result = petService.propertySearchPet(petPropertySearchDTO);
        int total = petDao.propertySearchCount(petPropertySearchDTO.getName(), petPropertySearchDTO.getPhone());

        Map<String,Object> res = new HashMap<>();
        res.put("total", total);
        res.put("tableData", result);

        if(res != null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"Search failed");
        }

    }

    @ApiOperation(value = "proprietorSearchPet", notes = "Proprietor searches for pets")  // Swagger annotation
    @PostMapping("/proprietorsearchpet")
    public Result proprietorSearchPet(@RequestBody PetProprietorSearchDTO petProprietorSearchDTO){

        List<Pet> result = petService.proprietorSearchPet(petProprietorSearchDTO);

        if(result != null){
            return Result.success(result);
        }else{
            return Result.error(Constants.CODE_600,"Search failed");
        }

    }

    @ApiOperation(value = "proprietorSetPet", notes = "Proprietor updates pet information")  // Swagger annotation
    @PostMapping("/proprietorsetpet")
    public Result proprietorSetPet(@RequestBody ProprietorSetPetInfoDTO proprietorSetPetInfoDTO){

        Integer res = petService.proprietorSetPet(proprietorSetPetInfoDTO);

        if(res != null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"Update failed");
        }

    }
}
