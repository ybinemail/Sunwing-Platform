package com.sunwing.platform.boot.common.base;

import com.sunwing.platform.boot.common.enums.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

@ApiModel(description = "通用响应类")
@Getter
@ToString
public class Result<T> {
    @ApiModelProperty(value = "是否成功",required = true)
    private  boolean success;

    @ApiModelProperty(value = "响应代码",required = true)
    private int code;

    @ApiModelProperty(value = "提示信息",required = true)
    private String msg;

    @ApiModelProperty(value = "响应数据")
    private T data;

    private Result(int code, String msg, T data){
        this.success = ResultCodeEnum.SUCCESS.code == code;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     *
     * @param resultCodeEnum
     */
    private Result(ResultCodeEnum resultCodeEnum){
        this(resultCodeEnum.code,resultCodeEnum.msg,null);
    }

    private Result(ResultCodeEnum resultCodeEnum, String msg){
        this(resultCodeEnum.code,msg,null);
    }

    private Result(ResultCodeEnum resultCodeEnum, T data){
        this(resultCodeEnum.code, resultCodeEnum.msg, data);
    }

    private Result(ResultCodeEnum resultCodeEnum, T data, String msg){
        this(resultCodeEnum.code, msg, data);
    }

    public static <T> Result<T> data(T data){
        return new Result<>(ResultCodeEnum.SUCCESS.code, ResultCodeEnum.SUCCESS.msg, data);
    }

    public static <T> Result<T> data(String msg,T data){
        return new Result<>(ResultCodeEnum.SUCCESS, data,msg);
    }

    public static <T> Result<T> data(int code ,String msg, T data){
        return  new Result<>(code,msg,data);
    }

    public static <T> Result<T> sucess(){
        return  new Result<>(ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> sucess(String msg){
        return  new Result<>(ResultCodeEnum.SUCCESS,msg);
    }

    public static <T> Result<T> sucess(ResultCodeEnum resultCodeEnum){
        return new Result<>(resultCodeEnum);
    }

    public static <T> Result<T> success(ResultCodeEnum resultCodeEnum,String msg){
        return  new Result<>(resultCodeEnum,msg);
    }

    public static <T> Result<T> error(){
        return  new Result<>(ResultCodeEnum.ERROR, ResultCodeEnum.ERROR.msg);
    }

    public static <T> Result<T> error(String msg){
        return  new Result<>(ResultCodeEnum.ERROR,msg);
    }

    public static <T> Result<T> error(int code ,String msg){
        return new Result<>(code,msg,null);
    }

    public static <T> Result<T> error(ResultCodeEnum resultCodeEnum){
        return new Result<>(resultCodeEnum);
    }

    public static <T> Result<T> error(ResultCodeEnum resultCodeEnum,String msg){
        return  new Result<>(resultCodeEnum,msg);
    }

    public static <T> Result<T> result(boolean flag) {
        return flag ? Result.sucess("操作成功") : Result.error("操作失败");
    }
}
