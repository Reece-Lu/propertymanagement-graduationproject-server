package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorChangeCarInfoDTO;
import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorRegisterDTO;
import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorSearchDTO;
import com.reecelu.pmsserver.controller.DTO.Car.PropertySearchCarDTO;
import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryPropertySearchDTO;
import com.reecelu.pmsserver.dao.CarDao;
import com.reecelu.pmsserver.entity.Car;
import com.reecelu.pmsserver.entity.ExpressDelivery;
import com.reecelu.pmsserver.service.CarService;
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
@RequestMapping("/pms/car")
@Resource
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    CarDao carDao;

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

    //Post请求-物业快递查询
    @ApiOperation(value = "propertysearchcar",notes = "物业车辆查询")  //swagger注释
    @PostMapping("/propertysearchcar")
    public Result propertySearchCar(@RequestBody PropertySearchCarDTO propertySearchCarDTO){

        Integer total= carDao.countPropertySearchCar(propertySearchCarDTO.getName(), propertySearchCarDTO.getPhone());
        //使用 ExpressDelivery (快递)类型的对象获取 getExpressDeliveryInfo 返回结果
        List<Car> result = carService.propertySearchCar(propertySearchCarDTO);
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
