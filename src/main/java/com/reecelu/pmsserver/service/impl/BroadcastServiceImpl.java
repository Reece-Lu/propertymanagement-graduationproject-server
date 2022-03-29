package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.Broadcast.BroadcastPropertyCreateDTO;
import com.reecelu.pmsserver.controller.DTO.Broadcast.BroadcastPropertyDeleteDTO;
import com.reecelu.pmsserver.dao.BroadcastDao;
import com.reecelu.pmsserver.entity.Broadcast;
import com.reecelu.pmsserver.service.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BroadcastServiceImpl implements BroadcastService {

    @Autowired
    BroadcastDao broadcastDao;

    public Integer propertyCreateBroadcast(BroadcastPropertyCreateDTO broadcastPropertyCreateDTO){
        int createManagerId = broadcastPropertyCreateDTO.getCreateManagerId();
        String importanceLevel = broadcastPropertyCreateDTO.getImportanceLevel();
        String issueName = broadcastPropertyCreateDTO.getIssueName();
        String content = broadcastPropertyCreateDTO.getContent();
        String isDeleted = broadcastPropertyCreateDTO.getIsDeleted();
        Timestamp createDate = Timestamp.valueOf(broadcastPropertyCreateDTO.getCreateDate());

        return broadcastDao.propertyCreateBroadcast(createManagerId, importanceLevel,issueName, content , isDeleted,createDate);
    }

    public List<Broadcast> generalSearchBroadcast(){
        List<Broadcast> all = broadcastDao.generalSearchBroadcast();
//        删除已被标记删除的数据
        for(int i = 0; i<all.size() ;i++){
            if(all.get(i).getIsDeleted() == 1){
                all.remove(i);
                i=i-1;
            }
        }
        return all;
    }

    public Integer propertyDeleteBroadcast(BroadcastPropertyDeleteDTO broadcastPropertyDeleteDTO){
        return broadcastDao.propertyDeleteBroadcast(broadcastPropertyDeleteDTO.getId());
    }

}
