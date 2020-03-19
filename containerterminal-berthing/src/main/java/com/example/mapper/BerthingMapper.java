package com.example.mapper;

import com.example.entity.BerthingInfo;
import com.example.entity.PreShipInfo;

import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-17 12:59
 * @description: com.example.mapper
 */
public interface BerthingMapper {
    /***
     * 泊位信息录入
     * @param berthingInfo
     */
    void berthInfoEntry(BerthingInfo berthingInfo);

    /***
     * 根据泊位编号查询泊位类型
     * @param berthingId
     * @return
     */
    String queryBerthType(String berthingId);

    /***
     * 查询所有泊位信息
     * @return
     */
    List<BerthingInfo> berthingInfoQuery();

    /***
     * 根据泊位编号查询空闲状态
     * @param berthingId
     * @return
     */
    String queryBerthLeisure(String berthingId);

    /***
     * 根据泊位号查询泊位安排信息
     * @param berthingId
     * @return
     */
    List<BerthingInfo> berthingInfoQueryById(String berthingId);

    /***
     * 到港申请列表
     * @return
     */
    List<PreShipInfo> preShipInfoQuery();

    /***
     * 到港申请同意
     * @param shipId
     */
    void agree(String shipId);

    /***
     * 到港申请拒绝
     * @param shipId
     */
    void refuse(String shipId);

    /***
     * 根据船舶编号查询该船预泊信息
     * @param shipId
     * @return
     */
    PreShipInfo queryByShipId(String shipId);
}
