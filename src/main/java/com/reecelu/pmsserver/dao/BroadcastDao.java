package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.Broadcast;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface BroadcastDao {
//  物业·创建广播通知
    Integer propertyCreateBroadcast(int createManagerId, String importanceLevel ,String issueName ,String content , String isDeleted , Timestamp createDate);
//  通用·查询广播通知
    List<Broadcast> generalSearchBroadcast();

}
