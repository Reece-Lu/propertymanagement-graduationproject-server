package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.Car.CarProprietorRegisterDTO;
import org.springframework.stereotype.Service;

@Service
public interface CarService {
    Integer proprietorRegisterCar(CarProprietorRegisterDTO carProprietorRegisterDTO);
}
