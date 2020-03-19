package com.example.service;

import com.example.entity.ContainerInfo;
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
public class YardService implements YardMapper {
    @Resource
    private YardMapper yardMapper;
    public void containerEntry(ContainerInfo containerInfo) {
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.format(date);
        containerInfo.setCreateTime(date);
        yardMapper.containerEntry(containerInfo);
    }


    public List<ContainerInfo> containerQuery() {
        return yardMapper.containerQuery();
    }

    /***
     * 集装箱出场
     * @param containerId
     */
    public void containerExit(String containerId) {
        yardMapper.containerExit(containerId);
    }

}
