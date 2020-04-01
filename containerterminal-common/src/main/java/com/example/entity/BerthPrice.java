package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 魏秦
 * @Date: 2020-03-24 11:35
 * @description: com.example.entity
 */
@Data
public class BerthPrice {
    private String priceId;
    private String shipId;
    private Double priceStandard;
    private Double overTimeStandard;
    private String effectiveTime;
    private String failureTime;
}
