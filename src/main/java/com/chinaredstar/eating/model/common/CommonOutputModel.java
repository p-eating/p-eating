package com.chinaredstar.eating.model.common;


/**
 * @description: face++ api公共出参
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:37 2017/12/18
 * @modified by:
 */
public class CommonOutputModel {


    private String requestId;

    private String timeUsed;

    private String errorMessage;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(String timeUsed) {
        this.timeUsed = timeUsed;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
