package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryPropertySetServicemanDTO;
import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryProprietorEntrustDTO;
import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryPropertySearchDTO;
import com.reecelu.pmsserver.controller.DTO.delivery.DeliveryProprietorTrackListDTO;
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

    // POST request - Property Express Delivery Search
    @ApiOperation(value = "propertysearch", notes = "Property express delivery search")  // Swagger annotation
    @PostMapping("/propertysearch")
    public Result expressDeliveryPropertySearch(@RequestBody DeliveryPropertySearchDTO deliveryPropertySearchDTO){

        Integer total = expressDeliveryDao.countExpressDelivery(deliveryPropertySearchDTO.getName(), deliveryPropertySearchDTO.getPhone());
        // Using ExpressDelivery object to obtain the getExpressDeliveryInfo result
        List<ExpressDelivery> result = expressDeliveryService.getExpressDeliveryInfo(deliveryPropertySearchDTO);
        // If the object res is empty, it implies no matching results in the database

        Map<String,Object> res = new HashMap<>();
        res.put("total", total);
        res.put("tableData", result);
        if (res != null) {
            return Result.success(res);
        } else {
            return Result.error(Constants.CODE_600, "Search failed");
        }

    }

    @ApiOperation(value = "proprietorEntrustDelivery", notes = "Proprietor applies for express delivery pickup service")
    @PostMapping("/proprietorentrustdelivery")
    public Result proprietorEntrustDelivery(@RequestBody DeliveryProprietorEntrustDTO deliveryProprietorEntrustDTO){

        Integer result = expressDeliveryService.entrustExpressDelivery(deliveryProprietorEntrustDTO);

        if (result != null) {
            return Result.success(result);
        } else {
            return Result.error(Constants.CODE_600, "Search failed");
        }

    }

    // POST - Add Delivery Serviceman for Property
    @ApiOperation(value = "propertyAddDeliveryServiceman", notes = "Proprietor applies for express delivery pickup service")
    @PostMapping("/propertyadddeliveryserviceman")
    public Result propertyAddDeliveryServiceman(@RequestBody DeliveryPropertySetServicemanDTO deliveryPropertySetServicemanDTO){

        Integer result = expressDeliveryService.addExpressDeliveryServiceman(deliveryPropertySetServicemanDTO);

        if (result != null) {
            return Result.success(result);
        } else {
            return Result.error(Constants.CODE_600, "Search failed");
        }

    }

    // POST - Proprietor Track Delivery Information
    @ApiOperation(value = "proprietorTrackDelivery", notes = "Proprietor tracks express delivery information")
    @PostMapping("/proprietortrackdelivery")
    public Result proprietorTrackDelivery(@RequestBody DeliveryProprietorTrackListDTO deliveryProprietorTrackListDTO){

        List<ExpressDelivery> res = expressDeliveryService.getExpressDeliveryInfoProprietor(deliveryProprietorTrackListDTO);

        if (res != null) {
            return Result.success(res);
        } else {
            return Result.error(Constants.CODE_600, "Search failed");
        }

    }

}
