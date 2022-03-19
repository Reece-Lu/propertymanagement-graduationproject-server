package com.reecelu.pmsserver.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarDao {
    // 业主·登记车辆
    Integer proprietorRegisterCar(int masterId,  String licensePlate, String parkingSpace, String colour);
}
