package com.aurora.common.model;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 公共结果model
 * @create 2020-04-29 23:18
 **/
@Getter
@Setter
public class ResultModel <T>  implements Serializable {


    private  int code;
    private  long count;
    private  String message;
    private  T data;

    public ResultModel(int code,String message){
        this.code = code;
        this.message = message;
    }

    public ResultModel(int code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultModel(int code, int count, String message, T data) {
        this.code = code;
        this.count = count;
        this.message = message;
        this.data = data;
    }

    public ResultModel(int code, String message, T data, long count) {
        this.code = code;
        this.count = count;
        this.message = message;
        this.data = data;
    }

    public static  ResultModel failure(ResultCode resultCode, String message){
        return new ResultModel(resultCode.getCode(),message) ;
    }

    public static  ResultModel result(ResultCode resultCode){
        return new ResultModel(resultCode.getCode(),resultCode.getMsg()) ;
    }

    public static  ResultModel success(ResultCode resultCode,Object msg){
        return new ResultModel(resultCode.getCode(), JSON.toJSONString(msg)) ;
    }

    /**
     * 成功不带参数
     * @return
     */
    public static  ResultModel success(){
        return new ResultModel(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg()) ;
    }

    /**
     * 成功分页返回
     * @param data
     * @param count
     * @return
     */
    public static  ResultModel successPage(Object data,long count){
        return new ResultModel(ResultCode.SUCCESS.getCode()
                ,ResultCode.SUCCESS.getMsg(),
                JSON.toJSONString(data),
                count
              ) ;
    }

    public static  ResultModel failure(ResultCode resultCode){
        return new ResultModel(resultCode.getCode(),resultCode.getMsg()) ;
    }

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
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
