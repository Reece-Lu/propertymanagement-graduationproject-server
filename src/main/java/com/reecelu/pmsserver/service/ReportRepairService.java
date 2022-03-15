package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.repair.RepairProprietorCheckListDTO;
import com.reecelu.pmsserver.controller.DTO.repair.RepairProprietorCreateReportDTO;
import com.reecelu.pmsserver.entity.ReportRepairs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportRepairService {

    List<ReportRepairs> getReportRepairs(String reporter, String repairType,int pageNum, int pageSize);

    Integer getSelectTotal(String reporter, String repairType);

    Integer setEditStatus(int id,String serviceman, String repairStatus);

    Integer createReport(RepairProprietorCreateReportDTO repairProprietorCreateReportDTO);

    List<ReportRepairs> getCheckFixingReport(RepairProprietorCheckListDTO repairProprietorCheckListDTO);

}
