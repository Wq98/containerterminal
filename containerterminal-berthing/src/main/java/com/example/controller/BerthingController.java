package com.example.controller;

import com.example.common.*;
import com.example.entity.BerthingInfo;
import com.example.entity.OperationInfo;
import com.example.entity.PreShipInfo;
import com.example.service.BerthingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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
    public SysResult berthInfoEntry(BerthingInfo berthingInfo, HttpServletRequest request){
        try {
            berthingService.berthInfoEntry(berthingInfo);
            String userId = CookieUtils.getCookieValue(request, "ticket");
            OperationInfo operationInfo=new OperationInfo();
            operationInfo.setOperationId(UUIDUtil.getUUID());
            operationInfo.setUserId(userId);
            operationInfo.setOperationContent("操作泊位信息录入");
            Date date=new Date();
            String df = DateFormat.dateFormat(date);
            operationInfo.setOperationTime(df);
            berthingService.operationEntry(operationInfo);
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

    @RequestMapping("berthingInfoQuery{page}{rows}")
    public EasyUIResult berthingInfoQuery(Integer page,Integer rows){
        EasyUIResult result=berthingService.berthingInfoQuery(page,rows);
        return result;
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

    @RequestMapping("preShipInfoQuery{page}{rows}")
    public EasyUIResult preShipInfoQuery(Integer page,Integer rows){
        EasyUIResult result = berthingService.preShipInfoQuery(page,rows);
        return result;

    }

    @RequestMapping("arrangeShipInfoQuery{page}{rows}")
    public EasyUIResult arrangeShipInfoQuery(Integer page,Integer rows){
        EasyUIResult result=berthingService.arrangeShipInfoQuery(page,rows);
        return result;
    }

    @RequestMapping("agree{id}")
    public SysResult agree(String id){
        try {
            berthingService.agree(id);
           return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"",null);
        }
    }

    @RequestMapping("refuse{id}")
    public SysResult refuse(String id){
        try {
            berthingService.refuse(id);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"",null);
        }
    }

    @RequestMapping("queryByMoreConditions{berthingId}{shipId}{berthingTime}{page}{rows}")
    public EasyUIResult queryByMoreConditions(String berthingId,String shipId,String berthingTime,Integer page,Integer rows){
        System.out.println("berthingId:"+berthingId+",shipId:"+shipId+",berthingTime:"+berthingTime);
           if(berthingId==null&&shipId==null&&berthingTime==""){
               EasyUIResult result=berthingService.berthingInfoQuery(page,rows);
               return result;
           }else {
               EasyUIResult result = berthingService.queryByMoreConditions(berthingId, shipId, berthingTime, page, rows);
               return result;
           }
    }

    @RequestMapping("queryBerthInfoId{berthingInfoId}")
    public ResponseResult queryBerthInfoId(String berthingInfoId){
        try {
            BerthingInfo berthingInfo=berthingService.queryBerthInfoId(berthingInfoId);
            return ResponseResult.build(200,"",berthingInfo);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("updateBerthing")
    public ResponseResult updateBerthing(BerthingInfo berthingInfo){
        try {
            berthingService.updateBerthing(berthingInfo);
            return ResponseResult.build(200,"",null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("deleteBerthInfoId{berthingInfoId}")
    public ResponseResult deleteBerthInfoId(String berthingInfoId){
        try {
            berthingService.deleteBerthInfoId(berthingInfoId);
            return ResponseResult.build(200,"",null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("removeList")
    public ResponseResult removeList(String str){
        try {
            String[] strings=str.split(",");
            for(String strs:strings) {
                System.out.println("strs:"+strs);
                berthingService.deleteBerthInfoId(strs);
            }
                return ResponseResult.build(200,"",null);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("queryByPreShipInfoState{page}{rows}")
    public EasyUIResult queryByPreShipInfoState(Integer page,Integer rows){
        EasyUIResult result=berthingService.queryByPreShipInfoState(page,rows);
        return result;
    }

    @RequestMapping("queryByPreShipInfoId{shipId}")
    public ResponseResult<List<PreShipInfo>> queryByPreShipInfoId(String shipId){
        try {
            List<PreShipInfo> list=berthingService.queryByPreShipInfoId(shipId);
            return ResponseResult.build(200,"",list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }
}
