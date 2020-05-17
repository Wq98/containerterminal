package com.example.mapper;

import com.example.entity.EquipmentDamageInfo;
import com.example.entity.EquipmentDto;
import com.example.entity.EquipmentInfo;
import com.example.entity.EquipmentOperationInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-04-11 11:09
 * @description: com.example.mapper
 */
public interface EquipmentMapper {
    /***
     * 根据泊位号查询设备作业信息
     * @param berthingId
     * @return
     */
    List<EquipmentDto> equipmentOperationInfoQuery(String berthingId);

    /***
     * 根据设备作业表id查询设备信息
     * @param id
     * @return
     */
    EquipmentDto equipmentOperationByIdQuery(String id);

    /***
     * 修改设备作业信息
     * @param equipmentOperationInfo
     */
    void updateEquipmentOperation(EquipmentOperationInfo equipmentOperationInfo);

    /***
     * 结束作业
     * @param id
     */
    void updateEquipmentOperationById(String id,String outTime);

    /***
     * 删除设备作业信息，逻辑删
     * @param id
     */
    void deleteEquipmentOperationById(String id);

    /***
     * 设备作业信息登记
     * @param equipmentOperationInfo
     */
    void equipmentOperationInfoEntry(EquipmentOperationInfo equipmentOperationInfo);

    /***
     * 获取所有设备id
     * @return
     */
    List<String> queryAllEquipmentId();

    /***
     * 查询报损设备总数
     * @return
     */
    int equipmentDamageQueryTotal();

    /***
     * 查询报损设备信息
     * @param start
     * @param rows
     * @return
     */
    List<EquipmentDamageInfo> equipmentDamageQuery(@Param("start") int start, @Param("rows") Integer rows);

    /***
     * 根据设备id查询设备报损信息
     * @param equipmentId
     * @return
     */
    List<EquipmentDamageInfo> queryByEquipmentDamageId(String equipmentId);

    /***
     * 设备报损信息登记
     * @param equipmentDamageInfo
     */
    void EquipmentDamageEntry(EquipmentDamageInfo equipmentDamageInfo);

    /***
     * 根据id查询设备报损信息
     * @param id
     * @return
     */
    EquipmentDamageInfo equipmentDamageByIdQuery(String id);

    /***
     * 修改设备报损状态
     * @param equipmentDamageInfo
     */
    void updateEquipmentDamageState(EquipmentDamageInfo equipmentDamageInfo);

    /***
     * 查询设备表条数
     * @return
     */
    int EquipmentInfoQueryTotal();

    /***
     * 查询设备表所有设备信息
     * @param start
     * @param rows
     * @return
     */
    List<EquipmentInfo> EquipmentInfoQuery(int start, Integer rows);

    /***
     * 根据设备表id删除设备信息
     * @param id
     */
    void deleteEquipmentInfoById(String id);

    /***
     * 根据设备表设备id查询设备信息
     * @param equipmentId
     * @return
     */
    EquipmentInfo queryByEquipmentId(String equipmentId);

    /***
     * 根据id查询设备表信息
     * @param id
     * @return
     */
    EquipmentInfo equipmentInfoByIdQuery(String id);

    /***
     * 根据id修改设备表信息
     * @param equipmentInfo
     */
    void updateEquipmentInfoById(EquipmentInfo equipmentInfo);
}
