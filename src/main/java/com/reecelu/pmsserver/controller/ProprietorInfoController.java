package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.proprietorArchives.ProprietorSetSelfInfoDTO;
import com.reecelu.pmsserver.controller.DTO.proprietorArchives.PropertyGetProprietorInfoDTO;
import com.reecelu.pmsserver.controller.DTO.proprietorArchives.ProprietorGetSelfInfoDTO;
import com.reecelu.pmsserver.dao.ProprietorInfoDao;
import com.reecelu.pmsserver.entity.Proprietor;
import com.reecelu.pmsserver.service.ProprietorInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pms/proprietorinfo")
@Resource
public class ProprietorInfoController {

    @Autowired
    ProprietorInfoService proprietorInfoService;

    @Autowired
    ProprietorInfoDao proprietorInfoDao;

    @ApiOperation(value = "getProprietorInfo", notes = "Retrieve proprietor's personal information")  // Swagger annotation
    @PostMapping("/getproprietorinfo")
    public Result getProprietorInfo(@RequestBody ProprietorGetSelfInfoDTO proprietorGetSelfInfoDTO){
        // Extract parameters from the request
        int id = proprietorGetSelfInfoDTO.getId();

        // Using Proprietor object to get the getProprietorInfo return result
        Proprietor proprietor = proprietorInfoService.getProprietorInfo(id);
        // If proprietor is found, return success, otherwise no such person found
        if(proprietor != null){
            return Result.success(proprietor);
        }else{
            return Result.error(Constants.CODE_600, "No such person found");
        }

    }

    @ApiOperation(value = "changeProprietorInfo", notes = "Modify proprietor's personal information, input values: account ID, attribute code, new value")  // Swagger annotation
    @PostMapping("/changeproprietorinfo")
    public Result changeProprietorInfo(@RequestBody ProprietorSetSelfInfoDTO proprietorSetSelfInfoDTO){
        // Extract parameters from the request
        int id = proprietorSetSelfInfoDTO.getId();
        int attribute = proprietorSetSelfInfoDTO.getAttribute();
        String value = proprietorSetSelfInfoDTO.getValue();
        System.out.println(attribute);

        // Using feedback type object to get changeProprietorInfo return result
        int feedback = proprietorInfoService.changeProprietorInfo(id, attribute, value);
        // If feedback is 1, then the information was successfully modified
        if(feedback == 1){
            return Result.success(feedback);
        }else{
            return Result.error(Constants.CODE_600, "Modification failed");
        }

    }

    @ApiOperation(value = "propertySearchProprietorInfo", notes = "Property searches for proprietor information")  // Swagger annotation
    @PostMapping("/propertysearchproprietorinfo")
    public Result propertySearchProprietorInfo(@RequestBody PropertyGetProprietorInfoDTO propertyGetProprietorInfoDTO){

        Integer total = proprietorInfoDao.countAllProperty(propertyGetProprietorInfoDTO.getName());
        // Using Proprietor object to get getAllProprietor return result
        List<Proprietor> result = proprietorInfoService.getAllProprietor(propertyGetProprietorInfoDTO);
        // If no matching results in the database

        Map<String,Object> res = new HashMap<>();
        res.put("total", total);
        res.put("tableData", result);
        if(res != null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600, "Search failed");
        }

    }

}
