package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorChangeCarInfoDTO;
import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorRegisterDTO;
import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorSearchDTO;
import com.reecelu.pmsserver.controller.DTO.Car.CarPropertySearchCarDTO;
import com.reecelu.pmsserver.dao.CarDao;
import com.reecelu.pmsserver.entity.Car;
import com.reecelu.pmsserver.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarDao carDao;

     public Integer proprietorRegisterCar(CarProprietorRegisterDTO carProprietorRegisterDTO){
         int masterId = carProprietorRegisterDTO.getMasterId();
         String licensePlate = carProprietorRegisterDTO.getLicensePlate();
         String parkingSpace = carProprietorRegisterDTO.getParkingSpace();
         String colour = carProprietorRegisterDTO.getColour();

         return carDao.proprietorRegisterCar(masterId , licensePlate , parkingSpace , colour);
     }

     public List<Car> proprietorSearchCar(CarProprietorSearchDTO carProprietorSearchDTO){
         int masterId = carProprietorSearchDTO.getMasterId();

         return carDao.proprietorSearchCar(masterId);
     }

     public Integer proprietorChangeCarInfo(CarProprietorChangeCarInfoDTO carProprietorChangeCarInfoDTO){
         int id = carProprietorChangeCarInfoDTO.getId();
         String licensePlate =carProprietorChangeCarInfoDTO.getLicensePlate();
         String parkingSpace = carProprietorChangeCarInfoDTO.getParkingSpace();
         String colour = carProprietorChangeCarInfoDTO.getColour();

         return carDao.proprietorChangeCarInfo(id, licensePlate , parkingSpace , colour);
     }

     public List<Car> propertySearchCar(CarPropertySearchCarDTO carPropertySearchCarDTO){
         String name = carPropertySearchCarDTO.getName();
         String phone = carPropertySearchCarDTO.getPhone();
         int pageNum=(carPropertySearchCarDTO.getPageNum()-1)* carPropertySearchCarDTO.getPageSize();
         int pageSize= carPropertySearchCarDTO.getPageSize();

         return carDao.propertySearchCar(name , phone , pageNum , pageSize);
     }
}
