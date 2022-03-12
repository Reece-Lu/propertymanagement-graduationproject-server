package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.ExpressDelivery;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ExpressDeliveryDao {
    // 封装searchExpressDelivery查询语句，指向ExpressDelivery.xml,用于物业端数据表格展示（模糊查询、分页查询）
    List<ExpressDelivery> searchExpressDelivery(String name,String phone,int pageNum, int pageSize);

    // 封装searchExpressDelivery查询语句，指向ExpressDelivery.xml,用于获取快递代领总数据条数
    Integer countExpressDelivery(String name,String phone);

    //封装entrustExpressDelivery插值语句，实现业主申请快递代领服务
    Integer entrustExpressDelivery(int proprietorId, String deliveryType, String deliveryLocation, String deliveryCode, Timestamp createDate, String status);
}
