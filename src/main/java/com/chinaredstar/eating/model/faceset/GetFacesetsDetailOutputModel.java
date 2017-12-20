package com.chinaredstar.eating.model.faceset;

import com.chinaredstar.eating.model.common.CommonOutputModel;

import java.util.List;

/**
 * @description:
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:40 2017/12/18
 * @modified by:
 */
public class GetFacesetsDetailOutputModel extends CommonOutputModel {

    private String facesetToken;
    private String faceCount;
    private String next;
    private List<String> faceTokens;

    public String getFacesetToken() {
        return facesetToken;
    }

    public void setFacesetToken(String facesetToken) {
        this.facesetToken = facesetToken;
    }

    public String getFaceCount() {
        return faceCount;
    }

    public void setFaceCount(String faceCount) {
        this.faceCount = faceCount;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<String> getFaceTokens() {
        return faceTokens;
    }

    public void setFaceTokens(List<String> faceTokens) {
        this.faceTokens = faceTokens;
    }
}
