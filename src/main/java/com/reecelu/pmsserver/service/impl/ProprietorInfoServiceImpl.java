package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.proprietorArchives.PropertyGetProprietorInfoDTO;
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

    //业主信息修改功能，根据传入的attribute值，判断需要修改的属性
    @Override
    public Integer changeProprietorInfo(int id, int attribute ,String value){
        int feedback=-1;
        if(attribute==1){
            feedback = proprietorInfoDao.updateName(id,value);
        }else if(attribute==2){
            feedback=proprietorInfoDao.updateTitle(id,value);
        }else if(attribute==3){
            feedback=proprietorInfoDao.updatePhone(id,value);
        }else if(attribute==4){
            feedback=proprietorInfoDao.updateEmail(id,value);
        }else if(attribute==5){
            feedback=proprietorInfoDao.updateWeChat(id,value);
        }else if(attribute==6){
            feedback=proprietorInfoDao.updateDoor(id,value);
        }else if(attribute==7){
            feedback=proprietorInfoDao.updateBuilding(id,value);
        }else{
            feedback=proprietorInfoDao.updateEoleInFamily(id,value);
        }
        return feedback;
    }

    //物业获取所有业主信息
    @Override
    public  List<Proprietor> getAllProprietor(PropertyGetProprietorInfoDTO propertyGetProprietorInfoDTO){
        String username = propertyGetProprietorInfoDTO.getUsername();

        int pageNum=(propertyGetProprietorInfoDTO.getPageNum()-1)* propertyGetProprietorInfoDTO.getPageSize();
        int pageSize= propertyGetProprietorInfoDTO.getPageSize();

        return proprietorInfoDao.PropertySearchAll(username,pageNum,pageSize);
    }
}
