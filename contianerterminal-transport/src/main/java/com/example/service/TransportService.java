package com.example.service;

import com.example.common.DateFormat;
import com.example.entity.TransportInfo;
import com.example.mapper.TransportMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-19 16:15
 * @description: com.example.service
 */
@Service
public class TransportService implements TransportMapper {
    @Resource
    private TransportMapper transportMapper;
    public void transportInfoEntry(TransportInfo transportInfo) {
        Date date=new Date();
        DateFormat.dateFormat(date);
        transportInfo.setCreateTime(date);
        transportMapper.transportInfoEntry(transportInfo);
    }

    public List<TransportInfo> transportInfoQuery() {
        return transportMapper.transportInfoQuery();
    }

    public void transportRemove(String transportId) {
        transportMapper.transportRemove(transportId);
    }

    public TransportInfo queryByTransportId(String transportId) {
        return transportMapper.queryByTransportId(transportId);
    }
}
