package com.reecelu.pmsserver.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 物业查询
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpressDeliveryPropertySearchDTO {
    private String name; //快递主人姓名-用于模糊查找
    private String phone; //快递主人联系方式-用于模糊查找
}
