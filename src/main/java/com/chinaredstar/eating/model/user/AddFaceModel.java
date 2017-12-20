package com.chinaredstar.eating.model.user;

import com.chinaredstar.eating.components.constants.FaceApiContants;
import com.chinaredstar.eating.model.common.CommonInputModel;

/**
 * @description:
 * @author: chaoyue<chaoyue.fan @ chinaredstar.com>
 * @date: Create in 18:42 2017/12/20
 * @version: 1.0.0
 * @modified by:
 */
public class AddFaceModel extends CommonInputModel {

    private String facesetToken = FaceApiContants.FACESET_TOKEN;

    private String faceTokens;

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
