package com.example.entity;

import lombok.Data;

/**
 * @Author: 魏秦
 * @Date: 2020-03-18 17:00
 * @description: com.example.entity
 */
@Data
public class NewsInfo {
    private String newsId;
    private String newsTitle;
    private String newsContent;
    private String newsDate;
}
