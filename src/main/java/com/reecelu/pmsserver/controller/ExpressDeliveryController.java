package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.AddDeliveryServicemanDTO;
import com.reecelu.pmsserver.controller.DTO.EntrustExpressDeliveryDTO;
import com.reecelu.pmsserver.controller.DTO.ExpressDeliveryPropertySearchDTO;
import com.reecelu.pmsserver.dao.ExpressDeliveryDao;
import com.reecelu.pmsserver.entity.ExpressDelivery;
import com.reecelu.pmsserver.service.ExpressDeliveryService;
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
@RequestMapping("/pms/expressdelivery")
@Resource
public class ExpressDeliveryController {

    @Autowired
    ExpressDeliveryService expressDeliveryService;

    @Autowired
    ExpressDeliveryDao expressDeliveryDao;

    //Post请求-物业快递查询
    @ApiOperation(value = "propertysearch",notes = "物业快递查询")  //swagger注释
    @PostMapping("/propertysearch")
    public Result ExpressDeliveryPropertySearch(@RequestBody ExpressDeliveryPropertySearchDTO expressDeliveryPropertySearchDTO){

        Integer total=expressDeliveryDao.countExpressDelivery(expressDeliveryPropertySearchDTO.getName(),expressDeliveryPropertySearchDTO.getPhone());
        //使用 ExpressDelivery (快递)类型的对象获取 getExpressDeliveryInfo 返回结果
        List<ExpressDelivery> result = expressDeliveryService.getExpressDeliveryInfo(expressDeliveryPropertySearchDTO);
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

    @ApiOperation(value = "proprietorEntrustDelivery",notes = "业主申请快递代领服务")
    @PostMapping("/proprietorentrustdelivery")
    public Result proprietorEntrustDelivery(@RequestBody EntrustExpressDeliveryDTO entrustExpressDeliveryDTO){

        Integer result= expressDeliveryService.entrustExpressDelivery(entrustExpressDeliveryDTO);

        if(result!=null){
            return Result.success(result);
        }else{
            return Result.error(Constants.CODE_600,"查询失败");
        }

    }

    //Post物业设置快递派件人
    @ApiOperation(value = "propertyAddDeliveryServiceman",notes = "业主申请快递代领服务")
    @PostMapping("/propertyadddeliveryserviceman")
    public Result propertyAddDeliveryServiceman(@RequestBody AddDeliveryServicemanDTO addDeliveryServicemanDTO){

        Integer result= expressDeliveryService.addExpressDeliveryServiceman(addDeliveryServicemanDTO);

        if(result!=null){
            return Result.success(result);
        }else{
            return Result.error(Constants.CODE_600,"查询失败");
        }

    }

}
