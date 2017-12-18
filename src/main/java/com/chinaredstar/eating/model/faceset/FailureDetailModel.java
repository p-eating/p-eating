package com.chinaredstar.eating.model.faceset;

/**
 * @description:
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 19:32 2017/12/18
 * @modified by:
 */
public class FailureDetailModel {
    private String reason;
    private String face_token;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFace_token() {
        return face_token;
    }

    public void setFace_token(String face_token) {
        this.face_token = face_token;
    }
}
