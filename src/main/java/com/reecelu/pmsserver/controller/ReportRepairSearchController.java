package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
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
        int pageNum=(reportRepairSearchDTO.getPageNum()-1)* reportRepairSearchDTO.getPageSize();
        int pageSize=reportRepairSearchDTO.getPageSize();

        //调用对应service层封装的getReportRepairs方法
        List<ReportRepairs> reportRepairs = reportRepairSearchService.getReportRepairs(reporter,repairType,pageNum,pageSize);
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
}
