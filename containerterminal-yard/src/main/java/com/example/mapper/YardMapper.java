package com.example.mapper;

import com.example.entity.ContainerInfo;
import com.example.entity.YardManagingInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-09 21:07
 * @description: com.example.mapper
 */
public interface YardMapper {
    /***
     * 集装箱入场
     * @param containerInfo
     */
    void containerEntry(ContainerInfo containerInfo);

    /***
     * 根据集装箱编号查询出场
     * @param containerId
     * @return
     */
    void containerExit(String containerId);

    /***
     * 根据堆场ID模糊查询堆场信息
     * @param yardId
     * @return
     */
    List<YardManagingInfo> queryByYardId(String yardId);

    /***
     * 根据堆场id精确查询堆场信息
     * @param yardId
     * @return
     */
    YardManagingInfo queryById(String yardId);

    /***
     * 根据集装箱编号查询
     * @param containerId
     * @return
     */
    ContainerInfo queryByContainerId(String containerId);

    /***
     * 查询集装箱信息总数
     * @return
     */
    int queryContainerTotal();

    /***
     * 集装箱信息分页查询
     * @param start
     * @param rows
     * @return
     */
    List<ContainerInfo> containerQuery(@Param("start") int start,@Param("rows") Integer rows);
}
