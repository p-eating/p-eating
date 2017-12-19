package com.chinaredstar.eating.model.faceset;

/**
 * @description:
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 19:32 2017/12/18
 * @modified by:
 */
public class FailureDetailModel {
    private String reason;
    private String faceToken;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }
}
