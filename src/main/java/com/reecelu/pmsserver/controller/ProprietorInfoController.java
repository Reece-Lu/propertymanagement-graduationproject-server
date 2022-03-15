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


    //业主
    @Autowired
    ProprietorInfoService proprietorInfoService;

    @Autowired
    ProprietorInfoDao proprietorInfoDao;

    @ApiOperation(value = "getProprietorInfo",notes = "获取业主个人信息")  //swagger注释
    @PostMapping("/getproprietorinfo")
    public Result getProprietorInfo(@RequestBody ProprietorGetSelfInfoDTO proprietorGetSelfInfoDTO){
        //取出请求中的参数
        int id= proprietorGetSelfInfoDTO.getId();

        //使用 proprietor(业主)类型的对象获取 getProprietorInfo 返回结果
        Proprietor proprietor=proprietorInfoService.getProprietorInfo(id);
        //proprietor，反正登陆成功
        if(proprietor!=null){
            return Result.success(proprietor);
        }else{
            return Result.error(Constants.CODE_600,"查无此人");
        }

    }

    //业主
    //业主信息修改功能，传入值：账号ID、属性码attribute、修改值value
    @ApiOperation(value = "changeProprietorInfo",notes = "修改业主个人信息，传入值：账号ID、属性码attribute、修改值value")  //swagger注释
    @PostMapping("/changeproprietorinfo")
    public Result changeProprietorInfo(@RequestBody ProprietorSetSelfInfoDTO proprietorSetSelfInfoDTO){
        //取出请求中的参数
        int id= proprietorSetSelfInfoDTO.getId();
        int attribute = proprietorSetSelfInfoDTO.getAttribute();
        String value= proprietorSetSelfInfoDTO.getValue();
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

    //物业
    //物业获取业主全部信息
    @ApiOperation(value = "propertysearchproprietorinfo",notes = "物业查询业主档案")  //swagger注释
    @PostMapping("/propertysearchproprietorinfo")
    public Result propertySearchProprietorInfo(@RequestBody PropertyGetProprietorInfoDTO propertyGetProprietorInfoDTO){

        Integer total=proprietorInfoDao.countAllProperty(propertyGetProprietorInfoDTO.getName());
        //使用 Proprietor (业主)类型的对象获取 getAllProprietor 返回结果
        List<Proprietor> result = proprietorInfoService.getAllProprietor(propertyGetProprietorInfoDTO);
        //若对象 res 为空则表明数据库为匹配到结果

        Map<String,Object> res=new HashMap<>();
        res.put("total",total);
        res.put("tableData",result);
        if(res!=null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"查询失败");
        }

    }



}
