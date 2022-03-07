package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.ReportRepairs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ReportRepairDao {

    //返回模糊查找结果，指向mapper中的reportRepairSearch.xml，使用reportRepairSearch中 id="reportRepairSearch" 的SQL语句
    List<ReportRepairs> reportRepairSearch(String reporter, String repairType,int pageNum, int pageSize);

    //返回模糊查找的数据量，指向mapper中的reportRepairSearch.xml，使用reportRepairSearch中 id="selectTotal" 的SQL语句
    Integer selectTotal(String reporter,@Param("repairType") String repair_type);

    //修改报修维修表中的维修状态相关属性，指向mapper中的reportRepairSearch.xml，使用reportRepairSearch中 id="editStatus" 的SQL语句
    Integer editStatus(int id,String serviceman, @Param("repairStatus") String repair_status);

    //业主创建维修功能，指向mapper中的reportRepairSearch.xml，使用reportRepairSearch中 id="createReport" 的SQL语句
    Integer createReport(String reporter, int reporterId, String reporterPhone, Timestamp reportTime, String repairType, String repairLocation, String repairDescription, String repairStatus);

    //业主查询报修历史
    List<ReportRepairs> checkFixingReport(int reporterId);
}
