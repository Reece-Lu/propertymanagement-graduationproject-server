package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.Broadcast.BroadcastPropertyCreateDTO;
import org.springframework.stereotype.Service;

@Service
public interface BroadcastService {

    Integer propertyCreateBroadcast(BroadcastPropertyCreateDTO broadcastPropertyCreateDTO);
}
