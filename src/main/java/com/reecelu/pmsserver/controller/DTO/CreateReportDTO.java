package com.reecelu.pmsserver.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  业主创建维修工单功能
 *  */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateReportDTO {
    private String reporter;
    private String reporterPhone;
    private String reportTime;
    private String repairType;
    private String repairLocation;
    private String repairDescription;
    private String repairStatus;
}
