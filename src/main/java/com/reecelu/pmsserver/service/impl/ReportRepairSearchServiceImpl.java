package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.dao.ReportRepairSearchDao;
import com.reecelu.pmsserver.entity.ReportRepairs;
import com.reecelu.pmsserver.service.ReportRepairSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportRepairSearchServiceImpl implements ReportRepairSearchService {

    //调用Dao层中的ReportRepairSearchDao对象
    @Autowired
    ReportRepairSearchDao reportRepairSearchDao;

    //返回报修维修模糊查找结果
    public List<ReportRepairs> getReportRepairs(String reporter, String repairType,int pageNum, int pageSize){
        return reportRepairSearchDao.reportRepairSearch(reporter,repairType,pageNum,pageSize);
    }

    //返回报修维修页数据条数统计结果
    @Override
    public Integer getSelectTotal(String reporter, String repairType) {
        return reportRepairSearchDao.selectTotal(reporter,repairType);
    }

    //报修维修表中维修状态相关信息的修改
    public Integer setEditStatus(int id,String serviceman, String repairStatus){
        return reportRepairSearchDao.editStatus(id,serviceman,repairStatus);
    }
}
