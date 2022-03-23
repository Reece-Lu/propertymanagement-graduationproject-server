package com.reecelu.pmsserver.dao;

import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

@Mapper
public interface DecorationDao {
//    业主·装修登记
    Integer proprietorRegisterDecoration(int proprietorId, Timestamp startTime, Timestamp endTime, String building , String door , String constructionCrew);
}
