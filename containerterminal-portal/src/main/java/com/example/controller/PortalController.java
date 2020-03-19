package com.example.controller;

import com.example.entity.NewsInfo;
import com.example.service.PortalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-18 17:08
 * @description: com.example.controller
 */
@RestController
@RequestMapping("portal")
public class PortalController {
    @Resource
    private PortalService portalService;

    @RequestMapping("queryNews")
    public List<NewsInfo> queryNews(){
        List<NewsInfo> list=portalService.queryNews();
        return list;
    }
}
