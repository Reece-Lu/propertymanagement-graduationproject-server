package com.reecelu.pmsserver.controller.DTO.Decoration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecorationPropertySearchDTO {
    private String name;
    private String phone;
    private int pageNum;
    private int pageSize;
}
