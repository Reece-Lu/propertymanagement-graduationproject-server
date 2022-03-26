package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.Broadcast.BroadcastPropertyCreateDTO;
import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorRegisterDTO;
import com.reecelu.pmsserver.dao.BroadcastDao;
import com.reecelu.pmsserver.dao.CarDao;
import com.reecelu.pmsserver.service.BroadcastService;
import com.reecelu.pmsserver.service.CarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
}
