package com.reecelu.pmsserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet extends Proprietor{
    private int id;
    private int masterId;
    private String petName;
    private int age;
    private String createDate;
    private String species;
}
