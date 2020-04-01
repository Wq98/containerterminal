package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 魏秦
 * @Date: 2020-03-24 11:34
 * @description: com.example.entity
 */
@Data
public class YardPrice {
    private String priceId;
    private String yardId;
    private Double priceStandard;
    private Double overTimeStandard;
    private String effectiveTime;
    private String failureTime;
}
