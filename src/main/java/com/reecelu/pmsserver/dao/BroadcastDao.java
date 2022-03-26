package com.reecelu.pmsserver.dao;

import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

@Mapper
public interface BroadcastDao {

    Integer propertyCreateBroadcast(int createManagerId, String importanceLevel ,String content , String isDeleted , Timestamp createDate);
}
