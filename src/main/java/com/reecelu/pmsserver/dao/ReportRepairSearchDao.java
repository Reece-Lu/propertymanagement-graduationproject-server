package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.ReportRepairs;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportRepairSearchDao {

    //指向mapper中的reportRepairSearch.xml，使用reportRepairSearch中 id="reportRepairSearch 的SQL语句
    List<ReportRepairs> reportRepairSearch(String reporter, String repairType,int pageNum, int pageSize);


    Integer selectTotal(String reporter,@Param("repairType") String repair_type);
}
