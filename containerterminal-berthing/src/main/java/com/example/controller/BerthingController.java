package com.example.controller;

import com.example.common.SysResult;
import com.example.entity.BerthingInfo;
import com.example.entity.PreShipInfo;
import com.example.service.BerthingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-17 12:59
 * @description: com.example.controller
 */
@RestController
@RequestMapping("berthing")
public class BerthingController {
    @Resource
    private BerthingService berthingService;

    /***
     * 泊位信息录入
     * @param berthingInfo
     * @return
     */
    @RequestMapping("berthInfoEntry")
    public SysResult berthInfoEntry(BerthingInfo berthingInfo){
        try {
            berthingService.berthInfoEntry(berthingInfo);
            return SysResult.build(200,"",berthingInfo);
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"",null);
        }
    }

    @RequestMapping("queryBerthType{berthingId}")
    public SysResult queryBerthType(String berthingId){
        String berthType=berthingService.queryBerthType(berthingId);
        return SysResult.build(200,"",berthType);
    }

    @RequestMapping("berthingInfoQuery")
    public List<BerthingInfo> berthingInfoQuery(){
        List<BerthingInfo> list=berthingService.berthingInfoQuery();
        return list;
    }

    @RequestMapping("queryBerthLeisure{berthingId}")
    public SysResult queryBerthLeisure(String berthingId){

            String isLeisure=berthingService.queryBerthLeisure(berthingId);
            if(isLeisure!=null) {
                return SysResult.build(200, "", isLeisure);
            }else{
                String message="空闲";
                return SysResult.build(201, "", message);
            }
    }

    @RequestMapping("berthingInfoQueryById{berthingId}")
    public List<BerthingInfo> berthingInfoQueryById(String berthingId){
        List<BerthingInfo> list=berthingService.berthingInfoQueryById(berthingId);
        return list;
    }

    @RequestMapping("preShipInfoQuery")
    public List<PreShipInfo> preShipInfoQuery(){
        List<PreShipInfo> list=berthingService.preShipInfoQuery();
        return list;
    }

    @RequestMapping("agree{shipId}")
    public SysResult agree(String shipId){
        try {
            berthingService.agree(shipId);
           return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"",null);
        }
    }

    @RequestMapping("refuse{shipId}")
    public SysResult refuse(String shipId){
        try {
            berthingService.refuse(shipId);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"",null);
        }
    }
}
