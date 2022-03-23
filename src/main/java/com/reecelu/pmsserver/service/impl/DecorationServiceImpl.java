package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.Decoration.DecorationProprietorRegisterDTO;
import com.reecelu.pmsserver.dao.DecorationDao;
import com.reecelu.pmsserver.service.DecorationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class DecorationServiceImpl implements DecorationService {

    @Autowired
    DecorationDao decorationDao;

    public Integer ProprietorDecorationRegister(DecorationProprietorRegisterDTO decorationProprietorRegisterDTO){
        int proprietorId = decorationProprietorRegisterDTO.getProprietorId();
        Timestamp startTime = Timestamp.valueOf(decorationProprietorRegisterDTO.getStartTime());
        Timestamp endTime = Timestamp.valueOf(decorationProprietorRegisterDTO.getEndTime());
        String building = decorationProprietorRegisterDTO.getBuilding();
        String door = decorationProprietorRegisterDTO.getDoor();
        String constructionCrew = decorationProprietorRegisterDTO.getConstructionCrew();

        return decorationDao.proprietorRegisterDecoration(proprietorId, startTime, endTime, building, door, constructionCrew );

    }
}
