package com.reecelu.pmsserver.controller.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyGetProprietorInfo {
    private String username;
    private int pageNum;
    private int pageSize;
}