package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorRegisterDTO;
import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryPropertySearchDTO;
import com.reecelu.pmsserver.entity.ExpressDelivery;
import com.reecelu.pmsserver.service.CarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pms/car")
@Resource
public class CarController {

    @Autowired
    CarService carService;

    //Post请求·业主·登记车辆
    @ApiOperation(value = "proprietyRegisterCar",notes = "业主登记车辆")  //swagger注释
    @PostMapping("/proprietyregistercar")
    public Result proprietyRegisterCar(@RequestBody CarProprietorRegisterDTO carProprietorRegisterDTO){

        Integer res=carService.proprietorRegisterCar(carProprietorRegisterDTO);

        if(res!=null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"登记失败");
        }

    }
}
