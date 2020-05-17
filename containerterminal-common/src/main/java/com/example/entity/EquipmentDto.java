package com.example.entity;

import lombok.Data;

/**
 * @Author: 魏秦
 * @Date: 2020-04-11 11:27
 * @description: com.example.entity
 */
@Data
public class EquipmentDto {
    private String id;
    private String equipmentId;
    private String equipmentName;
    private String berthingId;
    private String inTime;
    private String outTime;
}
