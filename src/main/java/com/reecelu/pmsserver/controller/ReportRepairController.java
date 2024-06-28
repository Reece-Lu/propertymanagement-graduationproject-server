package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.repair.RepairPropertyEditStatusDTO;
import com.reecelu.pmsserver.controller.DTO.repair.RepairPropertySearchDTO;
import com.reecelu.pmsserver.controller.DTO.repair.RepairProprietorCheckListDTO;
import com.reecelu.pmsserver.controller.DTO.repair.RepairProprietorCreateReportDTO;
import com.reecelu.pmsserver.entity.ReportRepairs;
import com.reecelu.pmsserver.service.ReportRepairService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pms/reportrepairsearch")
@Resource
public class ReportRepairController {

    @Autowired
    ReportRepairService reportRepairService;

    // POST method, retrieves parameters "reporter" and "repairType", returns search results, can also be used to select all when parameters are empty
    @ApiOperation(value = "reportRepairSearch", notes = "Fuzzy search for maintenance repair reports")
    @PostMapping
    public Result reportRepairSearch(@RequestBody RepairPropertySearchDTO repairPropertySearchDTO){
        // Extract incoming parameters
        String reporter = repairPropertySearchDTO.getReporter();
        String repairType = repairPropertySearchDTO.getRepairType();
        // pageNum corresponds to the SQL statement's LIMIT condition start value, pageSize corresponds to the "step size"
        int pageNum = (repairPropertySearchDTO.getPageNum() - 1) * repairPropertySearchDTO.getPageSize();
        int pageSize = repairPropertySearchDTO.getPageSize();

        // Call the corresponding service layer's getReportRepairs method to obtain the fuzzy search results
        List<ReportRepairs> reportRepairs = reportRepairService.getReportRepairs(reporter, repairType, pageNum, pageSize);
        // Call the corresponding service layer's getSelectTotal method to obtain the count of data
        Integer total = reportRepairService.getSelectTotal(reporter, repairType);
        Map<String,Object> res = new HashMap<>();
        res.put("total", total);
        res.put("data", reportRepairs);

        // If ReportRepairs is empty, it implies the query returned no results
        if(reportRepairs != null){
            return Result.success(res);
        } else {
            return Result.error(Constants.CODE_600, "No results found");
        }
    }

    // POST method, input parameters repair id, modify attributes "serviceman" and "repairStatus", return operation result
    @ApiOperation(value = "editStatus", notes = "Modify the serviceman and repair status")
    @PostMapping("/editstatus")
    public Result editStatus(@RequestBody RepairPropertyEditStatusDTO repairPropertyEditStatusDTO){
        // Retrieve data from DTO object
        int id = repairPropertyEditStatusDTO.getId();
        String serviceman = repairPropertyEditStatusDTO.getServiceman();
        String repairStatus = repairPropertyEditStatusDTO.getRepairStatus();
        // Call Service's setEditStatus function
        Integer res = reportRepairService.setEditStatus(id, serviceman, repairStatus);

        if(res != null){
            return Result.success(res);
        } else {
            return Result.error(Constants.CODE_600, "Modification failed");
        }
    }

    /**
     * Functionality for proprietors to create repair reports
     * Parameters correspond to database attributes
     */
    @ApiOperation(value = "createReport", notes = "Functionality for proprietors to create repair reports")  // Swagger annotation
    @PostMapping("/createreport")
    public Result createReport(@RequestBody RepairProprietorCreateReportDTO repairProprietorCreateReportDTO){

        // Use feedback type object to get createReport return result
        int feedback = reportRepairService.createReport(repairProprietorCreateReportDTO);
        // If feedback is 1, then the information was successfully modified
        if(feedback == 1){
            return Result.success(feedback);
        } else {
            return Result.error(Constants.CODE_600, "Submission failed");
        }
    }

    /**
     * Functionality for proprietors to check their repair history
     * Input parameter is the proprietor ID
     * Returns data in descending order
     */
    @ApiOperation(value = "checkFixingReport", notes = "Functionality for proprietors to check their repair history")  // Swagger annotation
    @PostMapping("/checkfixingreport")
    public Result checkFixingReport(@RequestBody RepairProprietorCheckListDTO repairProprietorCheckListDTO){

        // Use feedback type object to get checkFixingReport return result
        List<ReportRepairs> res=reportRepairService.getCheckFixingReport(repairProprietorCheckListDTO);
        //feedback为1，则说明信息修改成功
        if(res!=null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"ERROR");
        }
    }

}