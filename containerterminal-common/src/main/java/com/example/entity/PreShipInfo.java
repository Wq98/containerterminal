package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 魏秦
 * @Date: 2020-03-18 12:19
 * @description: com.example.entity
 */
@Data
public class PreShipInfo {
    private String shipId;
    private String preBerthingTime;
    private String preLeavingTime;
    private String shipType;
    private Double cargoTonnage;
    private String preShipState;
    private Date createTime;
    private Date modifyTime;
}
