package com.reecelu.pmsserver.controller.DTO.proprietorArchives;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyGetProprietorInfoDTO {
    private String name;
    private int pageNum;
    private int pageSize;
}
