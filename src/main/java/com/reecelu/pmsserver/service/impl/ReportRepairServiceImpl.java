package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.CreateReportDTO;
import com.reecelu.pmsserver.dao.ReportRepairDao;
import com.reecelu.pmsserver.entity.ReportRepairs;
import com.reecelu.pmsserver.service.ReportRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ReportRepairServiceImpl implements ReportRepairService {

    //调用Dao层中的ReportRepairSearchDao对象
    @Autowired
    ReportRepairDao reportRepairDao;

    //返回报修维修模糊查找结果
    public List<ReportRepairs> getReportRepairs(String reporter, String repairType,int pageNum, int pageSize){
        return reportRepairDao.reportRepairSearch(reporter,repairType,pageNum,pageSize);
    }

    //返回报修维修页数据条数统计结果
    @Override
    public Integer getSelectTotal(String reporter, String repairType) {
        return reportRepairDao.selectTotal(reporter,repairType);
    }

    //报修维修表中维修状态相关信息的修改
    public Integer setEditStatus(int id,String serviceman, String repairStatus){
        return reportRepairDao.editStatus(id,serviceman,repairStatus);
    }

    public Integer createReport(CreateReportDTO createReportDTO){
        //将createReportDTO的数据取出给createReport函数
        String reporter =createReportDTO.getReporter();
        String reporterPhone= createReportDTO.getReporterPhone();
        //将String类型的reportTime转为数据库需要的Timestamp类型
        Timestamp reportTime = Timestamp.valueOf(createReportDTO.getReportTime());
        String repairType=createReportDTO.getRepairType();
        String repairLocation=createReportDTO.getRepairLocation();
        String repairDescription=createReportDTO.getRepairDescription();
        String repairStatus=createReportDTO.getRepairStatus();

        return reportRepairDao.createReport(reporter,reporterPhone,reportTime,repairType,repairLocation,repairDescription,repairStatus);
    }
}
