package com.example.entity;

import lombok.Data;

/**
 * @Author: 魏秦
 * @Date: 2020-04-11 16:14
 * @description: com.example.entity
 */
@Data
public class EquipmentDamageInfo {
    private String id;
    private String equipmentId;
    private String applyRepairTime;
    private String state;
}
