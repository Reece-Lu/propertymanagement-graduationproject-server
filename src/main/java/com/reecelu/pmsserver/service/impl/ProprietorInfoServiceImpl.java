package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.dao.ProprietorInfoDao;
import com.reecelu.pmsserver.entity.Proprietor;
import com.reecelu.pmsserver.service.ProprietorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprietorInfoServiceImpl implements ProprietorInfoService {

    @Autowired
    ProprietorInfoDao proprietorInfoDao;

    @Override
    public Proprietor getProprietorInfo(int id){
        List<Proprietor> proprietorInfo = proprietorInfoDao.SearchProprietorInfo(id);
        if (proprietorInfo.size() == 0) {
            return null;
        } else {
            return proprietorInfo.get(0);
        }

    }
}
