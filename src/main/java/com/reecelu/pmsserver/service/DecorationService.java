package com.reecelu.pmsserver.service;

import com.reecelu.pmsserver.controller.DTO.Decoration.DecorationProprietorRegisterDTO;
import org.springframework.stereotype.Service;

@Service
public interface DecorationService {
    Integer ProprietorDecorationRegister(DecorationProprietorRegisterDTO decorationProprietorRegisterDTO);
}
