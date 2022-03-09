package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.ExpressDelivery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExpressDeliveryDao {
    // 封装searchExpressDelivery查询语句，指向ExpressDelivery.xml,用于物业端数据表格展示（模糊查询、分页查询）
    List<ExpressDelivery> searchExpressDelivery(String name,String phone);
}
