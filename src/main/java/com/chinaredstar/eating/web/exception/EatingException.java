package com.chinaredstar.eating.web.exception;

/**
 * @description: 业务异常
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:14 2017/12/19
 * @modified by:
 */
public class EatingException extends RuntimeException {

    private EatingExceptionCodeEnum code;

    public EatingException(EatingExceptionCodeEnum code) {
        this.code = code;
    }

    public EatingException(EatingExceptionCodeEnum code, String message) {
        super(message);
        this.code = code;
    }

    public EatingExceptionCodeEnum getCode() {
        return code;
    }

    public void setCode(EatingExceptionCodeEnum code) {
        this.code = code;
    }
}
