package com.example.mapper;

import com.example.entity.TransportInfo;

import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-19 16:15
 * @description: com.example.mapper
 */
public interface TransportMapper {
    /***
     * 运输单信息录入
     * @param transportInfo
     */
    void transportInfoEntry(TransportInfo transportInfo);

    /***
     * 查询所有运输信息
     * @return
     */
    List<TransportInfo> transportInfoQuery();

    /***
     * 根据某个运输单号删除相关信息
     * @param transportId
     */
    void transportRemove(String transportId);

    /***
     * 根据运输单号查询信息
     * @param transportId
     * @return
     */
    TransportInfo queryByTransportId(String transportId);
}
