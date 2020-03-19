package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 魏秦
 * @Date: 2020-03-09 22:15
 * @description: com.example.entity
 */
@Data
public class ContainerInfo {
    private String containerId;
    private String containerType;
    private String inTime;
    private Date outTime;
    private String containerState;
    private Date createTime;
    private Date modifyTime;
}
