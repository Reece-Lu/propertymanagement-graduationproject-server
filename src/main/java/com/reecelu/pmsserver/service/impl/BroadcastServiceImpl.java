package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.Broadcast.BroadcastPropertyCreateDTO;
import com.reecelu.pmsserver.dao.BroadcastDao;
import com.reecelu.pmsserver.service.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class BroadcastServiceImpl implements BroadcastService {

    @Autowired
    BroadcastDao broadcastDao;

    public Integer propertyCreateBroadcast(BroadcastPropertyCreateDTO broadcastPropertyCreateDTO){
        int createManagerId = broadcastPropertyCreateDTO.getCreateManagerId();
        String importanceLevel = broadcastPropertyCreateDTO.getImportanceLevel();
        String content = broadcastPropertyCreateDTO.getContent();
        String isDeleted = broadcastPropertyCreateDTO.getIsDeleted();
        Timestamp createDate = Timestamp.valueOf(broadcastPropertyCreateDTO.getCreateDate());

        return broadcastDao.propertyCreateBroadcast(createManagerId, importanceLevel, content , isDeleted,createDate);
    }
}
