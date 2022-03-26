package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.Broadcast.BroadcastPropertyCreateDTO;
import com.reecelu.pmsserver.entity.Broadcast;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BroadcastService {

    Integer propertyCreateBroadcast(BroadcastPropertyCreateDTO broadcastPropertyCreateDTO);

    List<Broadcast> generalSearchBroadcast();
}
