package com.chinaredstar.eating.model.faceset;

import com.chinaredstar.eating.model.common.CommonOutputModel;

import java.util.List;

/**
 * @description:
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:40 2017/12/18
 * @modified by:
 */
public class CreateFacesetOutputModel extends CommonOutputModel {

    private String facesetToken;
    private String outerId;

    private String faceAdded;
    private String faceCount;

    private List<FailureDetailModel> failureDetail;


    public String getFacesetToken() {
        return facesetToken;
    }

    public void setFacesetToken(String facesetToken) {
        this.facesetToken = facesetToken;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public String getFaceAdded() {
        return faceAdded;
    }

    public void setFaceAdded(String faceAdded) {
        this.faceAdded = faceAdded;
    }

    public String getFaceCount() {
        return faceCount;
    }

    public void setFaceCount(String faceCount) {
        this.faceCount = faceCount;
    }

    public List<FailureDetailModel> getFailureDetail() {
        return failureDetail;
    }

    public void setFailureDetail(List<FailureDetailModel> failureDetail) {
        this.failureDetail = failureDetail;
    }
}
