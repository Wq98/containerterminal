package com.example.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 魏秦
 * @Date: 2020-03-20 9:51
 * @description: com.example.common
 */
@Data
public class ResponseResult<T> implements Serializable {
    //状态码
    private Integer code;
    //信息
    private String message;
    //数据
    private T data;

    public ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T>  ResponseResult<T> build(Integer code, String message, T data){
        return new ResponseResult<T>(code,message,data);
    }


}
