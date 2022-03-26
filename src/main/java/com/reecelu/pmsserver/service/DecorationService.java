package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.Decoration.DecorationPropertySearchDTO;
import com.reecelu.pmsserver.controller.DTO.Decoration.DecorationProprietorRegisterDTO;
import com.reecelu.pmsserver.entity.Decoration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DecorationService {
//    业主·装修登记
    Integer ProprietorDecorationRegister(DecorationProprietorRegisterDTO decorationProprietorRegisterDTO);
//    物业·装修查询
    List<Decoration> PropertySearchDecoration(DecorationPropertySearchDTO decorationPropertySearchDTO);
}
