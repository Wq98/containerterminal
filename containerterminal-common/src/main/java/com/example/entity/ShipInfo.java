package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 魏秦
 * @Date: 2020-03-17 10:04
 * @description: com.example.entity
 */
@Data
public class ShipInfo {
    private String shipId;
    private String typeId;
    private Date berthingTime;
    private String berthingId;
    private Double berthingCost;
    private String isDeparture;
    private Date arrivingTime;
    private String shipState;
    private Date createTime;
    private Date modifyTime;
}
