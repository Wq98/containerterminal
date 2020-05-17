package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 魏秦
 * @Date: 2020-03-23 9:56
 * @description: com.example.entity
 */
@Data
public class YardManagingInfo {
    private String yardId;
    private String containerId;
    private Double storingTime;
    private String inTime;
    private String outTime;
    private String state;
    private Date createTime;
    private String flag;
}
