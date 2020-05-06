package com.aurora.common.model;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author 公共结果model
 * @create 2020-04-29 23:18
 **/
public class ResultModel <T>  implements Serializable {


    private  int code;
    private  int count;
    private  String message;
    private  T data;

    public ResultModel(int code,String message){
        this.code = code;
        this.message = message;
    }

    public static  ResultModel failure(ResultCode resultCode,String message){
        return new ResultModel(resultCode.getCode(),message) ;
    }

    public static  ResultModel result(ResultCode resultCode){
        return new ResultModel(resultCode.getCode(),resultCode.getMsg()) ;
    }

    public static  ResultModel success(ResultCode resultCode,Object msg){
        return new ResultModel(resultCode.getCode(), JSON.toJSONString(msg)) ;
    }

    public static  ResultModel failure(ResultCode resultCode){
        return new ResultModel(resultCode.getCode(),resultCode.getMsg()) ;
    }

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"message\":\"" + message + '\"' +
                ", \"data\":\"" + data + '\"'+
                '}';
    }
}
