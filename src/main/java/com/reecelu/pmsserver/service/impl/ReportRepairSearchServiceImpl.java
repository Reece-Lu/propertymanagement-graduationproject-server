package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.dao.ReportRepairSearchDao;
import com.reecelu.pmsserver.entity.ReportRepairs;
import com.reecelu.pmsserver.service.ReportRepairSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportRepairSearchServiceImpl implements ReportRepairSearchService {

    @Autowired
    ReportRepairSearchDao reportRepairSearchDao;

    public List<ReportRepairs> getReportRepairs(String reporter, String repairType,int pageNum, int pageSize){
        return reportRepairSearchDao.reportRepairSearch(reporter,repairType,pageNum,pageSize);
    }

    @Override
    public Integer getSelectTotal(String reporter, String repairType) {
        return reportRepairSearchDao.selectTotal(reporter,repairType);
    }
}
