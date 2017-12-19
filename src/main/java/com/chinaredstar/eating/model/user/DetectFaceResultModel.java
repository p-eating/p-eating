package com.chinaredstar.eating.model.user;

/**
 * @description:
 * @author: chaoyue<chaoyue.fan @ chinaredstar.com>
 * @date: Create in 10:53 2017/12/19
 * @version: 1.0.0
 * @modified by:
 */
public class DetectFaceResultModel {

    private String faceToken;
    private Object facRectangle;

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }

    public Object getFacRectangle() {
        return facRectangle;
    }

    public void setFacRectangle(Object facRectangle) {
        this.facRectangle = facRectangle;
    }
}
