package com.example.controller;

import com.example.common.CookieUtils;
import com.example.common.EasyUIResult;
import com.example.common.ResponseResult;
import com.example.common.SysResult;
import com.example.entity.LoginInfo;
import com.example.entity.OperationInfo;
import com.example.entity.StaffInfo;
import com.example.entity.UserInfo;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-02-27 16:09
 * @description: com.example.controller
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public SysResult login(String staffId, String password, HttpServletRequest request, HttpServletResponse response){
        int exist = userService.queryExist(staffId, password);
        if(exist==0){
            return SysResult.build(201,"",null);
        }else{
            userService.login(staffId);
            CookieUtils.setCookie(request,response,"ticket",staffId);
            return SysResult.ok();
        }
    }

    @RequestMapping("logout")
    public SysResult logout(HttpServletRequest request, HttpServletResponse response){
        CookieUtils.deleteCookie(request, response, "ticket");
        return SysResult.ok();
    }

    @RequestMapping("queryOperation{userId}")
    public ResponseResult<List<OperationInfo>> queryOperation(String userId){
        try {
            List<OperationInfo> list=userService.queryOperation(userId);
            return ResponseResult.build(200,"",list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("queryByTime{start}{end}")
    public ResponseResult<List<OperationInfo>> queryByTime(String start,String end){
        List<OperationInfo> list=userService.queryByTime(start,end);
        return ResponseResult.build(200,"",list);
    }

    @RequestMapping("queryStaffInfoById{staffId}")
    public ResponseResult queryStaffInfoById(String staffId){
        StaffInfo staffInfo=userService.queryStaffInfoById(staffId);
        return ResponseResult.build(200,"",staffInfo);
    }

    @RequestMapping("queryByIdLoginInfo{staffId}{page}{rows}")
    public EasyUIResult queryByIdLoginInfo(String staffId,Integer page,Integer rows){
        EasyUIResult result=userService.queryByIdLoginInfo(staffId,page,rows);
        return result;
    }

    @RequestMapping("updateStaffInfo")
    public ResponseResult updateStaffInfo(StaffInfo staffInfo){
        userService.updateStaffInfo(staffInfo);
        return ResponseResult.build(200,"",null);
    }

    @RequestMapping("queryPasswordById{staffId}")
    public ResponseResult queryPasswordById(String staffId){
        String password=userService.queryPasswordById(staffId);
        return ResponseResult.build(200,"",password);
    }

    @RequestMapping("updatePasswordById")
    public ResponseResult updatePasswordById(HttpServletRequest request, HttpServletResponse response,UserInfo userInfo){
        userService.updatePasswordById(userInfo);
        CookieUtils.deleteCookie(request, response, "ticket");
        return ResponseResult.build(200,"",null);
    }
}
