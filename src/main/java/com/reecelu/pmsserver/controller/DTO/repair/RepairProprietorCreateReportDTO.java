package com.reecelu.pmsserver.controller.DTO.repair;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  业主创建维修工单功能
 *  */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepairProprietorCreateReportDTO {
    private String reporter;
    private int reporterId;
    private String reporterPhone;
    private String reportTime;
    private String repairType;
    private String repairLocation;
    private String repairDescription;
    private String repairStatus;
}
