package com.example.mapper;

import com.example.entity.NewsInfo;

import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-18 17:08
 * @description: com.example.mapper
 */
public interface PortalMapper {
    /***
     * 查询所有新闻
     * @return
     */
    List<NewsInfo> queryNews();
}
