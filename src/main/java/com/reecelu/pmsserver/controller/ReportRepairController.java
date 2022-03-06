package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.ChangeProprietorInfoDTO;
import com.reecelu.pmsserver.controller.DTO.CreateReportDTO;
import com.reecelu.pmsserver.controller.DTO.EditStatusDTO;
import com.reecelu.pmsserver.controller.DTO.ReportRepairSearchDTO;
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

    //post方法，获取参数"reporter"和"repairType"，返回查询结果，当参数为空时，也可用作selectAll
    @ApiOperation(value = "reportRepairSearch",notes = "报修维修表模糊查询")
    @PostMapping
    public Result reportrepairsearch(@RequestBody ReportRepairSearchDTO reportRepairSearchDTO){
        //取出传入参数
        String reporter=reportRepairSearchDTO.getReporter();
        String repairType=reportRepairSearchDTO.getRepairType();
        //pageNum对应SQl语句中Limit条件的Start值，pageSize对应SQL语句Limit条件的"步长"
        int pageNum=(reportRepairSearchDTO.getPageNum()-1)* reportRepairSearchDTO.getPageSize();
        int pageSize=reportRepairSearchDTO.getPageSize();

        //调用对应service层封装的getReportRepairs方法，获取模糊查询结果
        List<ReportRepairs> reportRepairs = reportRepairService.getReportRepairs(reporter,repairType,pageNum,pageSize);
        //调用对应service层封装的getSelectTotal方法，获取数据条数
        Integer total= reportRepairService.getSelectTotal(reporter,repairType);
        Map<String,Object> res=new HashMap<>();
        res.put("total",total);
        res.put("data",reportRepairs);

        //若ReportRepairs为空，则表明查询无果
        if(reportRepairs!=null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"登录失败");
        }
    }

    //post方法，传入参数维修id，修改属性维修人"serviceman"和维修状态"repairStatus"，返回操作结果
    @ApiOperation(value = "editStatus",notes = "修改维修人和维修状态")
    @PostMapping("/editstatus")
    public Result editStatus(@RequestBody EditStatusDTO editStatusDTO){
        //获取DTO对象中的数据
        int id=editStatusDTO.getId();
        String serviceman=editStatusDTO.getServiceman();
        String repairStatus=editStatusDTO.getRepairStatus();
        //调用Service中的setEditStatus函数
        Integer res = reportRepairService.setEditStatus(id,serviceman,repairStatus);

        if(res!=null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"修改失败");
        }
    }

    /**
     * 业主创建维修表单功能
     * 参数为数据库中对应的属性
     */
    @ApiOperation(value = "createReport",notes = "业主创建维修表单功能")  //swagger注释
    @PostMapping("/createreport")
    public Result changeInfo(@RequestBody CreateReportDTO createReportDTO){

        //使用 feedback类型的对象获取 getProprietorInfo 返回结果
        int feedback=reportRepairService.createReport(createReportDTO);
        //feedback为1，则说明信息修改成功
        if(feedback==1){
            return Result.success(feedback);
        }else{
            return Result.error(Constants.CODE_600,"提交失败");
        }

    }

}
