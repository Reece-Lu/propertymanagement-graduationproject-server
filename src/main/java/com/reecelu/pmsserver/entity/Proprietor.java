package com.reecelu.pmsserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proprietor {
    private int id;
    private String userName;
    private String password;
    private String name;
    private String title;
    private String phone;
    private String email;
    private String weChat;
    private String building;
    private String door;
    private String role_in_family;
}
