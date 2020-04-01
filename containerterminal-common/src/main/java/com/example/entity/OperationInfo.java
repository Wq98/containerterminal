package com.example.entity;

import lombok.Data;

/**
 * @Author: 魏秦
 * @Date: 2020-03-24 14:08
 * @description: com.example.entity
 */
@Data
public class OperationInfo {
    private String operationId;
    private String userId;
    private String operationContent;
    private String operationTime;
}
