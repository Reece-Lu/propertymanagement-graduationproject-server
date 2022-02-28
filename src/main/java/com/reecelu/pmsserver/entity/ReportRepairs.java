package com.reecelu.pmsserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportRepairs {
    private int id;
    private String reporter;
    private String reporterPhone;
    private String reportTime;
    private String repairType;
    private String repairLocation;
    private String repairDescription;
    private String serviceman;
    private String repairStatus;
    private String closure_time;
}
