package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 魏秦
 * @Date: 2020-03-21 15:29
 * @description: com.example.entity
 */
@Data
public class TransportInfo {
    private String transportId;
    private String consignorId;
    private String receiverId;
    private String loadingPort;
    private String destination;
    private String containerId;
    private String leavingTime;
    private String remarks;
    private Date createTime;
    private Date modifyTime;
}
