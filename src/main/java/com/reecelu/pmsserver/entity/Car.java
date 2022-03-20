package com.reecelu.pmsserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Car extends Proprietor{
    private int id;
    private int masterId;
    private String licensePlate;
    private String parkingSpace;
    private String colour;
}
