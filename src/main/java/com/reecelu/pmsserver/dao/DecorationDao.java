package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.Decoration;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface DecorationDao {
//    业主·装修登记
    Integer proprietorRegisterDecoration(int proprietorId, Timestamp startTime, Timestamp endTime, String building , String door , String constructionCrew);
//    物业·装修查找
    List<Decoration> propertySearchDecoration(String name,String phone,int pageNum, int pageSize);
//    物业·装修数据查找·统计
    Integer propertyCountSearchDecoration(String name , String phone);
}
