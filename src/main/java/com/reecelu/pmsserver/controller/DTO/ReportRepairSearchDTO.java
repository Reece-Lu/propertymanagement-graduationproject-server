package com.reecelu.pmsserver.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 报修维修页面数据表格的数据传输对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportRepairSearchDTO {
    private String reporter;
    private String repairType;
    private int pageNum;
    private int pageSize;
}
