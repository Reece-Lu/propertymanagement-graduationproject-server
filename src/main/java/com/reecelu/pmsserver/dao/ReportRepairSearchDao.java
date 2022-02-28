package com.reecelu.pmsserver.dao;

import com.reecelu.pmsserver.entity.ReportRepairs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportRepairSearchDao {

    //@Select("select * from report_repairs where reporter like concat('%',#{reporter},'%') and repair_type = #{repairType};")
    List<ReportRepairs> reportRepairSearch(String reporter, String repairType);
}
