package com.reecelu.pmsserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class car  extends Proprietor{
    private int id;
    private int masterId;
    private String licensePlate;
    private String parkingSpace;
    private String colour;
}
