package com.itxding.exceltion;

import lombok.Getter;

//自定义业务异常
@Getter
public class BusinessException extends RuntimeException{
    /**
     * 错误状态码
     */
    private int code;

    public BusinessException(String msg) {
        super(msg);
        this.code = 500;
    }

    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
