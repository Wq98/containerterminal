package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 魏秦
 * @Date: 2020-02-27 15:59
 * @description: com.example.entity
 */
@Data
public class StaffInfo {
    private String staffId;
    private String staffName;
    private String staffSex;
    private int staffAge;
    private String staffPhone;
    private String staffEmail;
    private Date createTime;
    private Date modifyTime;

}
