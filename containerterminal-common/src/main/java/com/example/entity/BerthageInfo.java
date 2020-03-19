package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 魏秦
 * @Date: 2020-03-17 9:59
 * @description: com.example.entity
 */
@Data
public class BerthageInfo {
    private String berthTypeId;
    private String berthingId;
    private Double maximumTonnage;
    private String berthType;
    private String berthTypeState;
    private Date createTime;
    private Date modifyTime;
}
