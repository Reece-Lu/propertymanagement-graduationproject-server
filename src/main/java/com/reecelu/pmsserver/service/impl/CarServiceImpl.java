package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorRegisterDTO;
import com.reecelu.pmsserver.dao.CarDao;
import com.reecelu.pmsserver.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
