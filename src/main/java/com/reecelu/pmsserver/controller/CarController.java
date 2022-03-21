package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorChangeCarInfoDTO;
import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorRegisterDTO;
import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorSearchDTO;
import com.reecelu.pmsserver.entity.Car;
import com.reecelu.pmsserver.service.CarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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


    //Post请求·业主·搜索车辆
    @ApiOperation(value = "proprietySearchCar",notes = "业主查询车辆")  //swagger注释
    @PostMapping("/proprietysearchcar")
    public Result proprietySearchCar(@RequestBody CarProprietorSearchDTO carProprietorSearchDTO){

        List<Car> result=carService.proprietorSearchCar(carProprietorSearchDTO);

        if(result!=null){
            return Result.success(result);
        }else{
            return Result.error(Constants.CODE_600,"登记失败");
        }

    }

    //Post请求·业主·修改车辆信息
    @ApiOperation(value = "proprietyChangeCarInfo",notes = "业主查询车辆")  //swagger注释
    @PostMapping("/proprietychangecarinfo")
    public Result proprietyChangeCarInfo(@RequestBody CarProprietorChangeCarInfoDTO carProprietorChangeCarInfoDTO){

        int res=carService.proprietorChangeCarInfo(carProprietorChangeCarInfoDTO);

        if(res!= 0){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"修改失败");
        }

    }
}
