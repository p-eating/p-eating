package com.chinaredstar.eating.model.faceset;

import com.chinaredstar.eating.model.common.CommonInputModel;

import javax.validation.constraints.NotNull;

/**
 * @description:
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:40 2017/12/18
 * @modified by:
 */
public class RemoveFacesetInputModel extends CommonInputModel {

    @NotNull(message = "不能为空")
    private String facesetToken;

    private String faceTokens = "RemoveAllFaceTokens";

    public String getFacesetToken() {
        return facesetToken;
    }

    public void setFacesetToken(String facesetToken) {
        this.facesetToken = facesetToken;
    }

    public String getFaceTokens() {
        return faceTokens;
    }

    public void setFaceTokens(String faceTokens) {
        this.faceTokens = faceTokens;
    }
}
