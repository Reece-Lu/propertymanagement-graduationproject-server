package com.reecelu.pmsserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private int id;
    private int masterId;
    private String name;
    private int age;
    private String createDate;
    private String species;
}