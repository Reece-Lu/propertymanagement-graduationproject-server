package com.reecelu.pmsserver.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建修改维修状态用的数据传输对象
 * 参数包括维修ID，维修人和维修状态
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditStatusDTO {
    private int id;
    private String serviceman;
    private String repairStatus;
}
