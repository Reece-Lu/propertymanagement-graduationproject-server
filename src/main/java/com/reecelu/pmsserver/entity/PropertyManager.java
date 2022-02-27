package com.reecelu.pmsserver.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyManager {
    private int id;
    private String userName;
    private String password;
    private String name;
    private String jobTitle;
    private String officePlace;
    private String phone;
    private String weChat;
    private String email;
}
