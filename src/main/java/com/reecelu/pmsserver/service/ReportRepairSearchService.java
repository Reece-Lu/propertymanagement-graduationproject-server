package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.entity.ReportRepairs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportRepairSearchService {
    List<ReportRepairs> getReportRepairs(String reporter, String repairType);
}
