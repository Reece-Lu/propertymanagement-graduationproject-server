package com.reecelu.pmsserver.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Broadcast extends PropertyManager{
    private int id;
    private int createManagerId;
    private String importanceLevel;
    private String content;
    private String isDeleted;
    private String createDate;

}
