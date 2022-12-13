package com.sunwing.platform.boot.common.exception;

import com.sunwing.platform.boot.common.enums.ResultCodeEnum;
import lombok.Getter;
import lombok.Setter;


@Getter
public class SystemException extends RuntimeException{
    private int code;

    private String msg;

    public SystemException(){
        this.code = ResultCodeEnum.ERROR.code;
        this.msg = ResultCodeEnum.ERROR.msg;
    }

    public SystemException(String msg){
        this.code = ResultCodeEnum.ERROR.code;
        this.msg = msg;
    }

    public SystemException(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public SystemException(Throwable throwable){
        super(throwable);
    }

    public SystemException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
