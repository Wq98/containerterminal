package com.example.service;

import com.example.common.DateFormat;
import com.example.common.EasyUIResult;
import com.example.common.UUIDUtil;
import com.example.entity.EquipmentDamageInfo;
import com.example.entity.EquipmentDto;
import com.example.entity.EquipmentInfo;
import com.example.entity.EquipmentOperationInfo;
import com.example.mapper.EquipmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-04-11 11:09
 * @description: com.example.service
 */
@Service
public class EquipmentService {
    @Resource
    private EquipmentMapper equipmentMapper;

    /***
     * 根据泊位号查询设备作业信息
     * @param berthingId
     * @return
     */
    public List<EquipmentDto> equipmentOperationInfoQuery(String berthingId) {
        return equipmentMapper.equipmentOperationInfoQuery(berthingId);
    }

    /***
     * 根据设备作业表id查询设备作业信息
     * @param id
     * @return
     */
    public EquipmentDto equipmentOperationByIdQuery(String id) {
        return equipmentMapper.equipmentOperationByIdQuery(id);
    }

    /***
     * 修改设备作业信息
     * @param equipmentDto
     */
    public void updateEquipmentOperation(EquipmentDto equipmentDto) {
        EquipmentOperationInfo equipmentOperationInfo=new EquipmentOperationInfo();
        equipmentOperationInfo.setId(equipmentDto.getId());
        equipmentOperationInfo.setEquipmentId(equipmentDto.getEquipmentId());
        equipmentOperationInfo.setBerthingId(equipmentDto.getBerthingId());
        equipmentOperationInfo.setInTime(equipmentDto.getInTime());
        equipmentOperationInfo.setOutTime(equipmentDto.getOutTime());
        equipmentMapper.updateEquipmentOperation(equipmentOperationInfo);
    }

    /***
     * 结束作业
     * @param id
     */
    public void updateEquipmentOperationById(String id) {
        Date date=new Date();
        String outTime= DateFormat.dateFormat1(date);
        equipmentMapper.updateEquipmentOperationById(id,outTime);
    }

    /***
     * 删除设备作业记录 逻辑删除
     * @param id
     */
    public void deleteEquipmentOperationById(String id) {
        equipmentMapper.deleteEquipmentOperationById(id);
    }

    /***
     * 设备作业信息登记
     * @param equipmentOperationInfo
     */
    public void equipmentOperationInfoEntry(EquipmentOperationInfo equipmentOperationInfo) {
        equipmentOperationInfo.setId(UUIDUtil.getUUID());
        equipmentMapper.equipmentOperationInfoEntry(equipmentOperationInfo);
    }

    /***
     * 获取所有设备id
     * @return
     */
    public List<String> queryAllEquipmentId() {
        return equipmentMapper.queryAllEquipmentId();
    }

    /***
     * 分页查询设备报损信息
     * @param page
     * @param rows
     * @return
     */
    public EasyUIResult equipmentDamageQuery(Integer page, Integer rows) {
        EasyUIResult result=new EasyUIResult();
        int total=equipmentMapper.equipmentDamageQueryTotal();
        result.setTotal(total);
        int start=(page-1)*rows;
        List<EquipmentDamageInfo> list=equipmentMapper.equipmentDamageQuery(start,rows);
        result.setRows(list);
        return result;
    }

    /***
     * 根据设备id查询设备报损信息
     * @param equipmentId
     * @return
     */
    public List<EquipmentDamageInfo> queryByEquipmentDamageId(String equipmentId) {
        return equipmentMapper.queryByEquipmentDamageId(equipmentId);
    }

    /***
     * 设备报损信息登记
     * @param equipmentDamageInfo
     */
    public void EquipmentDamageEntry(EquipmentDamageInfo equipmentDamageInfo) {
        equipmentDamageInfo.setId(UUIDUtil.getUUID());
        equipmentMapper.EquipmentDamageEntry(equipmentDamageInfo);
    }

    /***
     * 根据id查询设备报损信息
     * @param id
     * @return
     */
    public EquipmentDamageInfo equipmentDamageByIdQuery(String id) {
        return equipmentMapper.equipmentDamageByIdQuery(id);
    }

    /***
     * 修改设备报损状态
     * @param equipmentDamageInfo
     */
    public void updateEquipmentDamageState(EquipmentDamageInfo equipmentDamageInfo) {
        equipmentMapper.updateEquipmentDamageState(equipmentDamageInfo);
    }

    /***
     * 查询表设备所有信息
     * @param page
     * @param rows
     * @return
     */
    public EasyUIResult EquipmentInfoQuery(Integer page, Integer rows) {
        EasyUIResult result=new EasyUIResult();
        int total=equipmentMapper.EquipmentInfoQueryTotal();
        result.setTotal(total);
        int start=(page-1)*rows;
        List<EquipmentInfo> list=equipmentMapper.EquipmentInfoQuery(start,rows);
        result.setRows(list);
        return result;
    }

    /***
     * 根据设备表id删除设备信息
     * @param id
     */
    public void deleteEquipmentInfoById(String id) {
        equipmentMapper.deleteEquipmentInfoById(id);
    }

    /***
     * 根据设备表设备id查询设备信息
     * @param equipmentId
     * @return
     */
    public EquipmentInfo queryByEquipmentId(String equipmentId) {
        return equipmentMapper.queryByEquipmentId(equipmentId);
    }

    /***
     * 根据id查询设备表信息
     * @param id
     * @return
     */
    public EquipmentInfo equipmentInfoByIdQuery(String id) {
        return equipmentMapper.equipmentInfoByIdQuery(id);
    }

    public void updateEquipmentInfoById(EquipmentInfo equipmentInfo) {
        equipmentMapper.updateEquipmentInfoById(equipmentInfo);
    }
}
