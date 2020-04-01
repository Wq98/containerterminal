package com.example.controller;

import com.example.common.EasyUIResult;
import com.example.common.ResponseResult;
import com.example.common.SysResult;
import com.example.entity.ContainerInfo;
import com.example.entity.YardManagingInfo;
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
    @RequestMapping("containerQuery{page}{rows}")
    public EasyUIResult containerQuery(Integer page,Integer rows){
     EasyUIResult result= yardService.containerQuery(page,rows);
     return result;
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
            return SysResult.build(200,"",null);
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,e.getMessage(),null);
        }
    }
    @RequestMapping("queryByYardId{yardId}")
    public ResponseResult<List<YardManagingInfo>> queryByYardId(String yardId){
        try {
            List<YardManagingInfo> list=yardService.queryByYardId(yardId);
            return ResponseResult.build(200,"",list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("queryById{yardId}")
    public ResponseResult queryById(String yardId){
        try {
            YardManagingInfo yardManagingInfo=yardService.queryById(yardId);
            return ResponseResult.build(200,"",yardManagingInfo);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("queryByContainerId{containerId}")
    public ResponseResult queryByContainerId(String containerId){
        try {
            ContainerInfo containerInfo=yardService.queryByContainerId(containerId);
            return ResponseResult.build(200,"",containerInfo);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }
}
