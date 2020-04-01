package com.example.mapper;

import com.example.entity.LoginInfo;
import com.example.entity.OperationInfo;
import com.example.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-02-27 16:09
 * @description: com.example.mapper
 */
public interface UserMapper {

    /***
     * 用户登录时根据手机号和密码判断是否存在该用户
     * @param staffId,password
     * @return
     */
    int queryExist(String staffId, String password);

    /***
     * 将用户登录信息如登录时间、密码输入错误次数等存入登录信息表
     * @param loginInfo
     */
    void insertLogin(LoginInfo loginInfo);

    /***
     * 查询用户操作日志
     * @param userId
     * @return
     */
    List<OperationInfo> queryOperation(String userId);

    /***
     * 查询时间段操作信息
     * @param start
     * @param end
     * @return
     */
    List<OperationInfo> queryByTime(@Param("start") String start, @Param("end") String end);
}
