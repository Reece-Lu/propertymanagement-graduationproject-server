package com.reecelu.pmsserver.controller.DTO.proprietorArchives;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  业主信息修改功能
 *  */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProprietorSetSelfInfoDTO {
     private int id;
     private int attribute;
     private String value;
}
