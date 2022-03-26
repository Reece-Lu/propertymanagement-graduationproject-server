package com.reecelu.pmsserver.controller.DTO.Decoration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecorationProprietorRegisterDTO {
    private int proprietorId;
    private String startTime;
    private String endTime;
    private String building;
    private String door;
    private String constructionCrew;
}

