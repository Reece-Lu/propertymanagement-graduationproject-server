package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.entity.ReportRepairs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportRepairSearchService {

    List<ReportRepairs> getReportRepairs(String reporter, String repairType,int pageNum, int pageSize);

    Integer getSelectTotal(String reporter, String repairType);

    Integer setEditStatus(int id,String serviceman, String repairStatus);
}
