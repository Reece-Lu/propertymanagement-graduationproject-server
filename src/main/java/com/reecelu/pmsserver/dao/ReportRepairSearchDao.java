package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.ReportRepairs;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportRepairSearchDao {

    //返回模糊查找结果，指向mapper中的reportRepairSearch.xml，使用reportRepairSearch中 id="reportRepairSearch" 的SQL语句
    List<ReportRepairs> reportRepairSearch(String reporter, String repairType,int pageNum, int pageSize);

    //返回模糊查找的数据量，指向mapper中的reportRepairSearch.xml，使用reportRepairSearch中 id="selectTotal" 的SQL语句
    Integer selectTotal(String reporter,@Param("repairType") String repair_type);

    //修改报修维修表中的维修状态相关属性，指向mapper中的reportRepairSearch.xml，使用reportRepairSearch中 id="editStatus" 的SQL语句
    Integer editStatus(int id,String serviceman, @Param("repairStatus") String repair_status);
}
