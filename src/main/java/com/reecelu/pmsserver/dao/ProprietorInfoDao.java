package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.Proprietor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProprietorInfoDao {
    List<Proprietor> SearchProprietorInfo(int id);
}
