package com.example.service;

import com.example.common.UUIDUtil;
import com.example.entity.BerthingInfo;
import com.example.entity.PreShipInfo;
import com.example.mapper.BerthingMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-17 12:59
 * @description: com.example.service
 */
@Service
public class BerthingService implements BerthingMapper {
    @Resource
    private BerthingMapper berthingMapper;
    public void berthInfoEntry(BerthingInfo berthingInfo) {
        berthingInfo.setBerthingInfoId(UUIDUtil.getUUID());
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.format(date);
        berthingInfo.setCreateTime(date);
        berthingMapper.berthInfoEntry(berthingInfo);
    }


    public String queryBerthType(String berthingId) {
        return berthingMapper.queryBerthType(berthingId);
    }

    public List<BerthingInfo> berthingInfoQuery() {
        return berthingMapper.berthingInfoQuery();
    }

    public String queryBerthLeisure(String berthingId) {
        return berthingMapper.queryBerthLeisure(berthingId);
    }

    public List<BerthingInfo> berthingInfoQueryById(String berthingId) {
        return berthingMapper.berthingInfoQueryById(berthingId);
    }

    public List<PreShipInfo> preShipInfoQuery() {
        return berthingMapper.preShipInfoQuery();
    }

    public void agree(String shipId) {
        berthingMapper.agree(shipId);
      //  PreShipInfo preShipInfo = this.queryByShipId(shipId);



    }

    public void refuse(String shipId) {
        berthingMapper.refuse(shipId);
    }

    @Override
    public PreShipInfo queryByShipId(String shipId) {
        return berthingMapper.queryByShipId(shipId);
    }
}
