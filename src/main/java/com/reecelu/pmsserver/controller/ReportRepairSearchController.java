package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.EditStatusDTO;
import com.reecelu.pmsserver.controller.DTO.ReportRepairSearchDTO;
import com.reecelu.pmsserver.entity.ReportRepairs;
import com.reecelu.pmsserver.service.ReportRepairSearchService;
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
public class ReportRepairSearchController {

    @Autowired
    ReportRepairSearchService reportRepairSearchService;

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
        List<ReportRepairs> reportRepairs = reportRepairSearchService.getReportRepairs(reporter,repairType,pageNum,pageSize);
        //调用对应service层封装的getSelectTotal方法，获取数据条数
        Integer total=reportRepairSearchService.getSelectTotal(reporter,repairType);
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
        Integer res = reportRepairSearchService.setEditStatus(id,serviceman,repairStatus);

        if(res!=null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"修改失败");
        }
    }

}
