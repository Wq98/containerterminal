package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 魏秦
 * @Date: 2020-03-17 9:52
 * @description: com.example.entity
 */
@Data
public class BerthingInfo {
    private String berthingInfoId;
    private String berthingId;
    private String berthTypeId;
    private String shipId;
    private String isLeisure;
    private String berthingTime;
    private String leavingTime;
    private String berthingState;
    private Date createTime;
    private Date modifyTime;
}
