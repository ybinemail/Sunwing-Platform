package com.sunwing.platform.boot.common.exception;

import com.sunwing.platform.boot.common.enums.ResultCodeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
public class BusinessException extends RuntimeException {

    private int code;

    private String msg;

    public BusinessException(){
        this.code = ResultCodeEnum.FAILED.code;
        this.msg = ResultCodeEnum.FAILED.msg;
    }

    public BusinessException(String msg){
        this.code = ResultCodeEnum.FAILED.code;
        this.msg = msg;
    }

    public BusinessException(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(Throwable throwable){
        super(throwable);
    }

    public BusinessException(String msg, Throwable throwable){
        super(msg,throwable);
    }
}
