package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.entity.Proprietor;
import org.springframework.stereotype.Service;


@Service
public interface ProprietorInfoService {
    Proprietor getProprietorInfo(int id);

    Integer changeProprietorInfo(int id, int attribute ,String value);

}
