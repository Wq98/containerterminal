package com.example.controller;

import com.example.common.EasyUIResult;
import com.example.common.SysResult;
import com.example.entity.ContainerInfo;
import com.example.service.YardService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-09 21:07
 * @description: com.example.controller
 */
@RestController
@RequestMapping("/yard")
public class YardController {
    @Resource
    private YardService yardService;

    /***
     * 集装箱入场
     * @param containerInfo
     * @return
     */
    @RequestMapping("containerEntry")
    public SysResult containerEntry(ContainerInfo containerInfo){
        try {
            yardService.containerEntry(containerInfo);
            return SysResult.build(200,"ok",containerInfo);
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,e.getMessage(),null);
        }
    }

    /***
     * 集装箱出入场信息显示
     * @return
     */
    @RequestMapping("containerQuery")
    public List<ContainerInfo> containerQuery(){
     List<ContainerInfo> list= yardService.containerQuery();
     return list;
    }

    /***
     * 集装箱出场
     * @param containerId
     * @return
     */
    @RequestMapping("containerExit{containerId}")
    public SysResult containerExit(String containerId){
        try {
            yardService.containerExit(containerId);
            return SysResult.build(200,"",yardService.containerQuery());
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,e.getMessage(),null);
        }
    }
}
