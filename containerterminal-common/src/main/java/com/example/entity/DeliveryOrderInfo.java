package com.example.entity;

import lombok.Data;

/**
 * @Author: 魏秦
 * @Date: 2020-04-07 21:41
 * @description: com.example.entity
 */
@Data
public class DeliveryOrderInfo {
    private String deliveryOrderId;
    private String shipId;
    private String billNumber;
    private String goodsName;
    private String weight;
    private String size;
    private String loadingPort;
    private String destinationPort;
    private String consigneeName;
    private String address;
    private String phone;
}
