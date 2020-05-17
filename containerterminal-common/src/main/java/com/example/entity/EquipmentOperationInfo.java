package com.example.entity;

import lombok.Data;

/**
 * @Author: 魏秦
 * @Date: 2020-04-11 11:24
 * @description: com.example.entity
 */
@Data
public class EquipmentOperationInfo {
    private String id;
    private String equipmentId;
    private String berthingId;
    private String inTime;
    private String outTime;
    private int state;
}
