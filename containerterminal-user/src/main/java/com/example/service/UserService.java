package com.example.service;

import com.example.common.EasyUIResult;
import com.example.common.UUIDUtil;
import com.example.entity.LoginInfo;
import com.example.entity.OperationInfo;
import com.example.entity.StaffInfo;
import com.example.entity.UserInfo;
import com.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-02-29 15:12
 * @description: com.example.service
 */
@Service
public class UserService{
    @Resource
    private UserMapper userMapper;

    public int queryExist(String staffId, String password) {
        return userMapper.queryExist(staffId,password);
    }


    public void insertLogin(LoginInfo loginInfo) {
        userMapper.insertLogin(loginInfo);
    }

    public void login(String staffId) {
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.format(date);
        LoginInfo loginInfo=new LoginInfo();
        loginInfo.setLoginId(UUIDUtil.getUUID().replace("-",""));
        loginInfo.setStaffId(staffId);
        loginInfo.setLoginTime(date);
        this.insertLogin(loginInfo);
    }

    public List<OperationInfo> queryOperation(String userId) {
        return userMapper.queryOperation(userId);
    }

    public List<OperationInfo> queryByTime(String start, String end) {
        return userMapper.queryByTime(start,end);
    }

    public StaffInfo queryStaffInfoById(String staffId) {
        return userMapper.queryStaffInfoById(staffId);
    }

    public EasyUIResult queryByIdLoginInfo(String staffId, Integer page, Integer rows) {
        EasyUIResult result=new EasyUIResult();
        int total=userMapper.queryByStaffIdTotal(staffId);
        result.setTotal(total);
        int start=(page-1)*rows;
        List<LoginInfo> list=userMapper.queryByIdLoginInfo(staffId,start,rows);
        result.setRows(list);
        return result;
    }

    public void updateStaffInfo(StaffInfo staffInfo) {
        userMapper.updateStaffInfo(staffInfo);
    }

    public String queryPasswordById(String staffId) {
        return userMapper.queryPasswordById(staffId);
    }

    public void updatePasswordById(UserInfo userInfo) {
        userMapper.updatePasswordById(userInfo);
    }
}
