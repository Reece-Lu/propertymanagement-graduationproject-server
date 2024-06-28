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
    private String issueName;
    private String content;
    private int isDeleted;
    private String createDate;

}
