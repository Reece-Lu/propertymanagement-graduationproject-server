package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.Decoration.DecorationPropertySearchDTO;
import com.reecelu.pmsserver.controller.DTO.Decoration.DecorationProprietorRegisterDTO;
import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryPropertySearchDTO;
import com.reecelu.pmsserver.dao.DecorationDao;
import com.reecelu.pmsserver.entity.Decoration;
import com.reecelu.pmsserver.entity.ExpressDelivery;
import com.reecelu.pmsserver.service.DecorationService;
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
@RequestMapping("/pms/decoration")
@Resource
public class DecorationController {

    @Autowired
    DecorationService decorationService;

    @Autowired
    DecorationDao decorationDao;

    //Post请求-物业
    @ApiOperation(value = "proprietorRegisterDecoration",notes = "Property decoration registration")
    @PostMapping("/proprietorregisterdecoration")
    public Result proprietorRegisterDecoration(@RequestBody DecorationProprietorRegisterDTO decorationProprietorRegisterDTO){


        Integer res = decorationService.ProprietorDecorationRegister(decorationProprietorRegisterDTO);

        if(res!=null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"failed to register");
        }

    }

    //Post请求-物业装修查询
    @ApiOperation(value = "propertydecorationsearch",notes = "search decoration")  //swagger注释
    @PostMapping("/propertydecorationsearch")
    public Result PropertyDecorationSearch(@RequestBody DecorationPropertySearchDTO decorationPropertySearchDTO){

        Integer total=decorationDao.propertyCountSearchDecoration(decorationPropertySearchDTO.getName(), decorationPropertySearchDTO.getPhone());
        //使用 ExpressDelivery (快递)类型的对象获取 getExpressDeliveryInfo 返回结果
        List<Decoration> result = decorationService.PropertySearchDecoration(decorationPropertySearchDTO);
        //若对象 res 为空则表明数据库为匹配到结果

        Map<String,Object> res=new HashMap<>();
        res.put("total",total);
        res.put("tableData",result);
        if(res!=null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"failed to search");
        }

    }
}
