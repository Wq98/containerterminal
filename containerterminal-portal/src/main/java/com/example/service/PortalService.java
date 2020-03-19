package com.example.service;

import com.example.entity.NewsInfo;
import com.example.mapper.PortalMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-18 17:09
 * @description: com.example.service
 */
@Service
public class PortalService {
    @Resource
    private PortalMapper portalMapper;
    public List<NewsInfo> queryNews() {
        return portalMapper.queryNews();
    }
}
