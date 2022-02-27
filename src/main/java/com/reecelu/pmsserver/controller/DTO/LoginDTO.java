package com.reecelu.pmsserver.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建登陆用的数据传输对象
 * 前台请求包含参数用户名和密码
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    private String userName;
    private String password;
}
