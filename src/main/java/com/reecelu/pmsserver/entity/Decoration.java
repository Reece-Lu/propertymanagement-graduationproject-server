package com.reecelu.pmsserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Decoration extends Proprietor {

    private int id;
    private int proprietorId;
    private String startTime;
    private String endTime;
    private String building;
    private String door;
    private String constructionCrew;

}
