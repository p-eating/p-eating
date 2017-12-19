package com.chinaredstar.eating.model.faceset;

import com.chinaredstar.eating.model.common.CommonInputModel;

/**
 * @description:
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:40 2017/12/18
 * @modified by:
 */
public class CreateFacesetInputModel extends CommonInputModel {

    private String displayName;
    private String outerId;
    private String tags;
    private String faceTokens;
    private String userData;
    private String forceMerge = "0";

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getFaceTokens() {
        return faceTokens;
    }

    public void setFaceTokens(String faceTokens) {
        this.faceTokens = faceTokens;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public String getForceMerge() {
        return forceMerge;
    }

    public void setForceMerge(String forceMerge) {
        this.forceMerge = forceMerge;
    }
}
