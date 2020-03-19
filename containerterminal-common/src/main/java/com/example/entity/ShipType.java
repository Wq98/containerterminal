package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 魏秦
 * @Date: 2020-03-17 10:09
 * @description: com.example.entity
 */
@Data
public class ShipType {
    private String typeId;
    private String typeName;
    private String typeState;
    private Date createTime;
    private Date modifyTime;
}
