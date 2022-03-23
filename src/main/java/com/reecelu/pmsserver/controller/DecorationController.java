package com.reecelu.pmsserver.controller;

import com.reecelu.pmsserver.common.Constants;
import com.reecelu.pmsserver.common.Result;
import com.reecelu.pmsserver.controller.DTO.Decoration.DecorationProprietorRegisterDTO;
import com.reecelu.pmsserver.service.DecorationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pms/decoration")
@Resource
public class DecorationController {

    @Autowired
    DecorationService decorationService;

    //Post请求-物业
    @ApiOperation(value = "proprietorRegisterDecoration",notes = "物业装修登记")  //swagger注释
    @PostMapping("/proprietorregisterdecoration")
    public Result proprietorRegisterDecoration(@RequestBody DecorationProprietorRegisterDTO decorationProprietorRegisterDTO){


        Integer res = decorationService.ProprietorDecorationRegister(decorationProprietorRegisterDTO);

        if(res!=null){
            return Result.success(res);
        }else{
            return Result.error(Constants.CODE_600,"登记失败");
        }

    }
}
