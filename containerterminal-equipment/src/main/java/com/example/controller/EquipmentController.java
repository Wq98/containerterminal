package com.example.controller;

import com.example.common.EasyUIResult;
import com.example.common.ResponseResult;
import com.example.entity.EquipmentDamageInfo;
import com.example.entity.EquipmentDto;
import com.example.entity.EquipmentInfo;
import com.example.entity.EquipmentOperationInfo;
import com.example.service.EquipmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-04-11 11:08
 * @description: com.example.controller
 */
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Resource
    private EquipmentService equipmentService;

    @RequestMapping("equipmentOperationInfoQuery{berthingId}")
    public ResponseResult<List<EquipmentDto>> equipmentOperationInfoQuery(String berthingId){
        List<EquipmentDto> list=equipmentService.equipmentOperationInfoQuery(berthingId);
        return ResponseResult.build(200,"",list);
    }

    @RequestMapping("equipmentOperationByIdQuery{id}")
    public ResponseResult equipmentOperationByIdQuery(String id){
        EquipmentDto equipmentDto=equipmentService.equipmentOperationByIdQuery(id);
        return ResponseResult.build(200,"",equipmentDto);
    }
    @RequestMapping("updateEquipmentOperation")
    public ResponseResult updateEquipmentOperation(EquipmentDto equipmentDto){
        equipmentService.updateEquipmentOperation(equipmentDto);
        return ResponseResult.build(200,"",null);
    }

    @RequestMapping("updateEquipmentOperationById{id}")
    public ResponseResult updateEquipmentOperationById(String id){
        equipmentService.updateEquipmentOperationById(id);
        return ResponseResult.build(200,"",null);
    }

    @RequestMapping("deleteEquipmentOperationById{id}")
    public ResponseResult deleteEquipmentOperationById(String id){
        equipmentService.deleteEquipmentOperationById(id);
        return ResponseResult.build(200,"",null);
    }

    @RequestMapping("equipmentOperationInfoEntry")
    public ResponseResult equipmentOperationInfoEntry(EquipmentOperationInfo equipmentOperationInfo){
        equipmentService.equipmentOperationInfoEntry(equipmentOperationInfo);
        return ResponseResult.build(200,"",null);
    }

    @RequestMapping("queryAllEquipmentId")
    public ResponseResult queryAllEquipmentId(){
        List<String> list=equipmentService.queryAllEquipmentId();
        return ResponseResult.build(200,"",list);
    }

    @RequestMapping("equipmentDamageQuery{page}{rows}")
    public EasyUIResult equipmentDamageQuery(Integer page,Integer rows){
        EasyUIResult result=equipmentService.equipmentDamageQuery(page,rows);
        return result;
    }

    @RequestMapping("queryByEquipmentDamageId{equipmentId}")
    public ResponseResult<List<EquipmentDamageInfo>> queryByEquipmentDamageId(String equipmentId){
        List<EquipmentDamageInfo> list=equipmentService.queryByEquipmentDamageId(equipmentId);
        return ResponseResult.build(200,"",list);
    }

    @RequestMapping("EquipmentDamageEntry")
    public ResponseResult EquipmentDamageEntry(EquipmentDamageInfo equipmentDamageInfo){
        equipmentService.EquipmentDamageEntry(equipmentDamageInfo);
        return ResponseResult.build(200,"",null);
    }

    @RequestMapping("equipmentDamageByIdQuery{id}")
    public ResponseResult equipmentDamageByIdQuery(String id){
        EquipmentDamageInfo equipmentDamageInfo=equipmentService.equipmentDamageByIdQuery(id);
        return ResponseResult.build(200,"",equipmentDamageInfo);
    }

    @RequestMapping("updateEquipmentDamageState")
    public ResponseResult updateEquipmentDamageState(EquipmentDamageInfo equipmentDamageInfo){
        equipmentService.updateEquipmentDamageState(equipmentDamageInfo);
        return ResponseResult.build(200,"",null);
    }

    @RequestMapping("EquipmentInfoQuery{page}{rows}")
    public EasyUIResult EquipmentInfoQuery(Integer page,Integer rows){
        EasyUIResult result=equipmentService.EquipmentInfoQuery(page,rows);
        return result;
    }

    @RequestMapping("removeEquipmentInfoList")
    public ResponseResult removeEquipmentInfoList(String str){
        String[] strings=str.split(",");
        for(String strs:strings) {
            equipmentService.deleteEquipmentInfoById(strs);
        }
        return ResponseResult.build(200,"",null);
    }

    @RequestMapping("queryByEquipmentId{equipmentId}")
    public ResponseResult queryByEquipmentId(String equipmentId){
        System.out.println(equipmentId);
        EquipmentInfo equipmentInfo=equipmentService.queryByEquipmentId(equipmentId);
        return ResponseResult.build(200,"",equipmentInfo);
    }

    @RequestMapping("equipmentInfoByIdQuery{id}")
    public ResponseResult equipmentInfoByIdQuery(String id){
        System.out.println(id);
        EquipmentInfo equipmentInfo=equipmentService.equipmentInfoByIdQuery(id);
        return ResponseResult.build(200,"",equipmentInfo);
    }

    @RequestMapping("updateEquipmentInfoById")
    public ResponseResult updateEquipmentInfoById(EquipmentInfo equipmentInfo){
        equipmentService.updateEquipmentInfoById(equipmentInfo);
        return ResponseResult.build(200,"",null);
    }

    @RequestMapping("deleteEquipmentInfoById{id}")
    public ResponseResult deleteEquipmentInfoById(String id){
        equipmentService.deleteEquipmentInfoById(id);
        return ResponseResult.build(200,"",null);
    }
}
