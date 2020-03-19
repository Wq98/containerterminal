package com.example.mapper;

import com.example.entity.ContainerInfo;

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
     * 集装箱出入场信息查询
     * @return
     */
    List<ContainerInfo> containerQuery();

    /***
     * 根据集装箱编号查询出场
     * @param containerId
     * @return
     */
    void containerExit(String containerId);

    /***
     * 根据集装箱编号查询
     * @param containerId
     * @return
     */
   // ContainerInfo containerQueryById(String containerId);
}
