package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 魏秦
 * @Date: 2020-02-27 16:00
 * @description: com.example.entity
 */
@Data
public class LoginInfo {
    private String loginId;
    private String staffId;
    private Date loginTime;

}
