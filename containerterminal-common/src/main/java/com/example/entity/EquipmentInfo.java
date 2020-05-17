package com.example.entity;

import lombok.Data;

/**
 * @Author: 魏秦
 * @Date: 2020-04-11 10:52
 * @description: com.example.entity
 */
@Data
public class EquipmentInfo {
    private String id;
    private String equipmentId;
    private String equipmentName;
    private int equipmentTotalNum;
    private int freeNum;
    private String equipmentModel;
    private String equipmentState;
}
