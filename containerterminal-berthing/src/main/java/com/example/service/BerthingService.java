package com.example.service;

import com.example.common.DateFormat;
import com.example.common.EasyUIResult;
import com.example.common.UUIDUtil;
import com.example.entity.BerthingInfo;
import com.example.entity.OperationInfo;
import com.example.entity.PreShipInfo;
import com.example.mapper.BerthingMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-17 12:59
 * @description: com.example.service
 */
@Service
public class BerthingService{
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

    public EasyUIResult berthingInfoQuery(Integer page,Integer rows) {
        EasyUIResult result=new EasyUIResult();
        int total=berthingMapper.queryBerthingTotal();
        result.setTotal(total);
        int start=(page-1)*rows;
        List<BerthingInfo> list=berthingMapper.berthingInfoQuery(start,rows);
        result.setRows(list);
        return result;
    }

    public String queryBerthLeisure(String berthingId) {
        return berthingMapper.queryBerthLeisure(berthingId);
    }

    public List<BerthingInfo> berthingInfoQueryById(String berthingId) {
        return berthingMapper.berthingInfoQueryById(berthingId);
    }

    public EasyUIResult preShipInfoQuery(Integer page,Integer rows) {
        EasyUIResult result=new EasyUIResult();
        int total=berthingMapper.preShipInfoQueryTotal();
        result.setTotal(total);
        int start=(page-1)*rows;
        List<PreShipInfo> list=berthingMapper.preShipInfoQuery(start,rows);
        result.setRows(list);
        return result;
    }

    public void agree(String id) {
        berthingMapper.agree(id);
      //  PreShipInfo preShipInfo = this.queryByShipId(shipId);



    }

    public void refuse(String id) {
        berthingMapper.refuse(id);
    }


    public PreShipInfo queryByShipId(String shipId) {
        return berthingMapper.queryByShipId(shipId);
    }

    public EasyUIResult queryByMoreConditions(String berthingId, String shipId, String berthingTime,Integer page,Integer rows) {
        EasyUIResult result=new EasyUIResult();
        int total=berthingMapper.queryBerthingByConditionsTotal(berthingId, shipId, berthingTime);
        result.setTotal(total);
        int start=(page-1)*rows;
        List<BerthingInfo> list=berthingMapper.queryByMoreConditions(berthingId,shipId,berthingTime,start,rows);
        result.setRows(list);
        return result;
    }


    public void operationEntry(OperationInfo operationInfo) {
        berthingMapper.operationEntry(operationInfo);
    }

    public BerthingInfo queryBerthInfoId(String berthingInfoId) {
        return berthingMapper.queryBerthInfoId(berthingInfoId);
    }

    public void updateBerthing(BerthingInfo berthingInfo) {
        Date date=new Date();
        DateFormat.dateFormat(date);
        berthingInfo.setModifyTime(date);
        berthingMapper.updateBerthing(berthingInfo);
    }

    public void deleteBerthInfoId(String berthingInfoId) {
        berthingMapper.deleteBerthInfoId(berthingInfoId);
    }


    public EasyUIResult arrangeShipInfoQuery(Integer page, Integer rows) {
        EasyUIResult result=new EasyUIResult();
        int total=berthingMapper.arrangeShipInfoQueryTotal();
        result.setTotal(total);
        int start=(page-1)*rows;
        List<PreShipInfo> list=berthingMapper.arrangeShipInfoQuery(start,rows);
        result.setRows(list);
        return result;
    }

    public EasyUIResult queryByPreShipInfoState( Integer page, Integer rows) {
        EasyUIResult result=new EasyUIResult();
        int total=berthingMapper.queryByPreShipInfoStateTotal();
        result.setTotal(total);
        int start=(page-1)*rows;
        List<PreShipInfo> list=berthingMapper.queryByPreShipInfoState(start,rows);
        result.setRows(list);
        return result;
    }

    public List<PreShipInfo> queryByPreShipInfoId(String shipId) {
        return berthingMapper.queryByPreShipInfoId(shipId);
    }
}
