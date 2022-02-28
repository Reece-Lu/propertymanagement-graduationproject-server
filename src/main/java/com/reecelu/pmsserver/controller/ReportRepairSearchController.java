package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.ReportRepairSearchDTO;
import com.reecelu.pmsserver.entity.ReportRepairs;
import com.reecelu.pmsserver.service.ReportRepairSearchService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pms/reportrepairsearch")
@Resource
public class ReportRepairSearchController {

    @Autowired
    ReportRepairSearchService reportRepairSearchService;

    @ApiOperation(value = "reportRepairSearch",notes = "报修维修表查询")
    @PostMapping
    public Result reportrepairsearch(@RequestBody ReportRepairSearchDTO reportRepairSearchDTO){
        String reporter=reportRepairSearchDTO.getReporter();
        String repairType=reportRepairSearchDTO.getRepairType();

        List<ReportRepairs> reportRepairs = reportRepairSearchService.getReportRepairs(reporter,repairType);
        if(reportRepairs!=null){
            return Result.success(reportRepairs);
        }else{
            return Result.error(Constants.CODE_600,"登录失败");
        }

    }
}
