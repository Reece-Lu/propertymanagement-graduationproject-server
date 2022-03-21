package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorChangeCarInfoDTO;
import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorRegisterDTO;
import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorSearchDTO;
import com.reecelu.pmsserver.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    Integer proprietorRegisterCar(CarProprietorRegisterDTO carProprietorRegisterDTO);

    List<Car> proprietorSearchCar(CarProprietorSearchDTO carProprietorSearchDTO);

    //业主·修改车辆信息
    Integer proprietorChangeCarInfo(CarProprietorChangeCarInfoDTO carProprietorChangeCarInfoDTO);
}
