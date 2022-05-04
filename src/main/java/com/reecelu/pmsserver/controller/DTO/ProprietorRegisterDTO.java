package com.reecelu.pmsserver.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  业主注册·校验验证码·登记
 *  */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProprietorRegisterDTO {

    private String phone;
    private String code;

    private String userName;
    private String password;
    private String name;
    private String title;
    private String email;
    private String weChat;
    private String building;
    private String door;
    private String roleInFamily;

}
