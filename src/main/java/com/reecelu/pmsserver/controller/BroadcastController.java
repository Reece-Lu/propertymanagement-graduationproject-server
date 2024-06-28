package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.Broadcast.BroadcastPropertyCreateDTO;
import com.reecelu.pmsserver.controller.DTO.Broadcast.BroadcastPropertyDeleteDTO;
import com.reecelu.pmsserver.entity.Broadcast;
import com.reecelu.pmsserver.service.BroadcastService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pms/broadcast")
@Resource
public class BroadcastController {

    @Autowired
    BroadcastService broadcastService;


    //Post请求·物业·创建广播内容
    @ApiOperation(value = "propertyCreateBroadcast",notes = "业主创建广播")  //swagger注释
    @PostMapping("/propertycreatebroadcast")
    public Result propertyCreateBroadcast(@RequestBody BroadcastPropertyCreateDTO broadcastPropertyCreateDTO){

        Integer res=broadcastService.propertyCreateBroadcast(broadcastPropertyCreateDTO);

        if(res!=null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"创建失败");
        }

    }


    //Post请求·通用·查询广播内容
    @ApiOperation(value = "generalSearchBroadcast",notes = "搜索广播内容")  //swagger注释
    @PostMapping("/generalsearchbroadcast")
    public Result generalSearchBroadcast(){

        List<Broadcast> result = broadcastService.generalSearchBroadcast();

        if(result!=null){
            return Result.success(result);
        }else{
            return Result.error(Constants.CODE_600,"创建失败");
        }
    }

    //Post请求·通用·查询广播内容
    @ApiOperation(value = "propertyDeleteBroadcast",notes = "搜索广播内容")  //swagger注释
    @PostMapping("/propertydeletebroadcast")
    public Result propertyDeleteBroadcast(@RequestBody BroadcastPropertyDeleteDTO broadcastPropertyDeleteDTO){
        Integer res = broadcastService.propertyDeleteBroadcast(broadcastPropertyDeleteDTO) ;

        if(res!=null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"创建失败");
        }
    }


}
