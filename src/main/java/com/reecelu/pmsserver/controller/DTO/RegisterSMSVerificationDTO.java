package com.reecelu.pmsserver.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  业主注册·发送验证码
 *  */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterSMSVerificationDTO {
    private String phoneNum;
}
