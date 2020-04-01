package com.example.service;

import com.example.common.EasyUIResult;
import com.example.entity.ContainerInfo;
import com.example.entity.YardManagingInfo;
import com.example.mapper.YardMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-09 21:08
 * @description: com.example.service
 */
@Service
public class YardService {
    @Resource
    private YardMapper yardMapper;
    public void containerEntry(ContainerInfo containerInfo) {
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.format(date);
        containerInfo.setCreateTime(date);
        yardMapper.containerEntry(containerInfo);
    }


    public EasyUIResult containerQuery(Integer page,Integer rows) {
        EasyUIResult result=new EasyUIResult();
        int total=yardMapper.queryContainerTotal();
        result.setTotal(total);
        int start=(page-1)*rows;
        List<ContainerInfo> list=yardMapper.containerQuery(start,rows);
        result.setRows(list);
        return result;
    }

    /***
     * 集装箱出场
     * @param containerId
     */
    public void containerExit(String containerId) {
        yardMapper.containerExit(containerId);
    }

    /***
     * 根据堆场id模糊查询堆场信息
     * @param yardId
     * @return
     */
    public List<YardManagingInfo> queryByYardId(String yardId) {
        return yardMapper.queryByYardId(yardId);
    }

    /***
     * 根据堆场id精确查询堆场信息
     * @param yardId
     * @return
     */
    public YardManagingInfo queryById(String yardId) {
        return yardMapper.queryById(yardId);
    }

    public ContainerInfo queryByContainerId(String containerId) {
        return yardMapper.queryByContainerId(containerId);
    }
}
