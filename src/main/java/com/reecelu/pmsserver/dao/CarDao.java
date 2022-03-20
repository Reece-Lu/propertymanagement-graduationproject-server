package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarDao {
    // 业主·登记车辆
    Integer proprietorRegisterCar(int masterId,  String licensePlate, String parkingSpace, String colour);
    // 业主·查询车辆
    List<Car> proprietorSearchCar(int masterId);
}
