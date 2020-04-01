package com.example.mapper;

import com.example.entity.BerthingInfo;
import com.example.entity.OperationInfo;
import com.example.entity.PreShipInfo;
import org.apache.ibatis.annotations.Param;

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
    List<BerthingInfo> berthingInfoQuery(@Param("start") int start, @Param("rows") Integer rows);

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
    List<PreShipInfo> preShipInfoQuery(@Param("start")int start,@Param("rows")Integer rows);

    /***
     * 到港申请同意
     * @param id
     */
    void agree(String id);

    /***
     * 到港申请拒绝
     * @param id
     */
    void refuse(String id);

    /***
     * 根据船舶编号查询该船预泊信息
     * @param shipId
     * @return
     */
    PreShipInfo queryByShipId(String shipId);

    /***
     * 根据泊位号、船舶编号、靠泊时间动态查询泊位信息
     * @param berthingId
     * @param shipId
     * @param berthingTime
     * @return
     */
    List<BerthingInfo> queryByMoreConditions(String berthingId, String shipId, String berthingTime,@Param("start")int start,@Param("rows")Integer rows);

    /***
     * 插入操作信息
     * @param operationInfo
     */
    void operationEntry(OperationInfo operationInfo);

    /***
     * 根据泊位安排信息ID查询泊位安排信息
     * @param berthingInfoId
     * @return
     */
    BerthingInfo queryBerthInfoId(String berthingInfoId);

    /***
     * 修改泊位安排信息
     * @param berthingInfo
     */
    void updateBerthing(BerthingInfo berthingInfo);

    /***
     * 根据泊位安排信息ID删除泊位安排信息
     * @param berthingInfoId
     */
    void deleteBerthInfoId(String berthingInfoId);

    /***
     * 查询泊位安排信息总数
     * @return
     */
    int queryBerthingTotal();

    /***
     * 根据条件查询总数
     * @return
     */
    int queryBerthingByConditionsTotal(String berthingId, String shipId, String berthingTime);

    /***
     * 查询到港计划条数
     * @return
     */
    int preShipInfoQueryTotal();

    /***
     * 查询到港计划安排信息条数
     * @return
     */
    int arrangeShipInfoQueryTotal();

    /***
     * 查询到港安排信息
     * @param start
     * @param rows
     * @return
     */
    List<PreShipInfo> arrangeShipInfoQuery(@Param("start") int start, @Param("rows") Integer rows);

    /***
     * 根据状态查询
     * @return
     */
    int queryByPreShipInfoStateTotal();

    /***
     * 查询待审核状态申请记录
     * @param start
     * @param rows
     * @return
     */
    List<PreShipInfo> queryByPreShipInfoState(int start, Integer rows);

    /***
     * 根据船舶ID查询到港申请信息
     * @param shipId
     * @return
     */
    List<PreShipInfo> queryByPreShipInfoId(String shipId);
}
