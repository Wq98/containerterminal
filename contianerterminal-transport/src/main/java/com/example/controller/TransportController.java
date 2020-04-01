package com.example.controller;

import com.example.common.ResponseResult;
import com.example.entity.TransportInfo;
import com.example.service.TransportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-19 16:14
 * @description: com.example.controller
 */
@RestController
@RequestMapping("/transport")
public class TransportController {
    @Resource
    private TransportService transportService;

    @RequestMapping("transportInfoEntry")
    public ResponseResult transportInfoEntry(TransportInfo transportInfo){
        try {
            transportService.transportInfoEntry(transportInfo);
            return ResponseResult.build(200,"",null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("transportInfoQuery")
    public ResponseResult<List<TransportInfo>> transportInfoQuery(){
        try {
            List<TransportInfo> list=transportService.transportInfoQuery();
            return ResponseResult.build(200,"",list);
        }catch (Exception e){
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("transportRemove{transportId}")
    public ResponseResult transportRemove(String transportId){
        try {
            transportService.transportRemove(transportId);
            return ResponseResult.build(200,"",null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("queryByTransportId{transportId}")
    public ResponseResult queryByTransportId(String transportId){
        try {
            TransportInfo transportInfo=transportService.queryByTransportId(transportId);
            return ResponseResult.build(200,"",transportInfo);
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
                transportService.transportRemove(strs);
            }
            return ResponseResult.build(200,"",null);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }
}
