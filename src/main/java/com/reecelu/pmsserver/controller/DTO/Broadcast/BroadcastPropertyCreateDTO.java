package com.reecelu.pmsserver.controller.DTO.Broadcast;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BroadcastPropertyCreateDTO {
    private int createManagerId;
    private String importanceLevel;
    private String issueName;
    private String content;
    private String isDeleted;
    private String createDate;
}
