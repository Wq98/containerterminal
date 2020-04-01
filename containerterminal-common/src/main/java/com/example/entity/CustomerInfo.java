package com.example.entity;

import lombok.Data;

/**
 * @Author: 魏秦
 * @Date: 2020-03-24 10:07
 * @description: com.example.entity
 */
@Data
public class CustomerInfo {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String legalPerson;
    private int registerCapital;
    private int customerPhone;
    private String state;
    private String remarks;
}
