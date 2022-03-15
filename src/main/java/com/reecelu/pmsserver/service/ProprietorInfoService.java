package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.proprietorArchives.PropertyGetProprietorInfoDTO;
import com.reecelu.pmsserver.entity.Proprietor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProprietorInfoService {
    Proprietor getProprietorInfo(int id);

    Integer changeProprietorInfo(int id, int attribute ,String value);

    List<Proprietor> getAllProprietor(PropertyGetProprietorInfoDTO propertyGetProprietorInfoDTO);

}
