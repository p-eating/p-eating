package com.chinaredstar.eating.model.common;

import java.io.Serializable;

/**
 * @author:杨果
 * @date:16/3/10 上午9:29
 * <p/>
 * Description:
 * <p/>
 */
public class RestResultVo<T> implements Serializable {

    private static final long serialVersionUID = 6609358423117831573L;
    private int code;
    private String message;
    private T dataMap;

    public RestResultVo() {

    }

    public RestResultVo(int code, String message, T dataMap) {
        this.code = code;
        this.message = message;
        this.dataMap = dataMap;
    }

    public RestResultVo(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestResultVo(T dataMap) {
        this.dataMap = dataMap;
        this.code = RestResultCode.C200.getCode();
        this.message = RestResultCode.C200.getDesc();
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static <T> RestResultVo<T> getResult(T value) {
        return new RestResultVo<>(value);
    }

    public static RestResultVo getResult() {
        return new RestResultVo(null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getDataMap() {
        return dataMap;
    }

    public void setDataMap(T dataMap) {
        this.dataMap = dataMap;
    }

}
