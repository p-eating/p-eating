package com.chinaredstar.eating.web.exception;

/**
 * @description: 业务异常 码
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:15 2017/12/19
 * @modified by:
 */
public enum EatingExceptionCodeEnum {


    FACE_SERVICE_EXCEPTION(-1, "face server exception"),

    UNKNOWN_ERROR(10001, "unknown error exception"),

    NOT_RESULT_EXCEPTION(1001, "face server exception"),

    NOT_FACE_TOKEN_EXCEPTION(1002, "face server exception"),
    //
    ;


    private Integer code;

    private String msg;

    EatingExceptionCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
