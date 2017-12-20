package com.chinaredstar.eating.model.faceset;

import com.chinaredstar.eating.model.common.CommonInputModel;

/**
 * @description:
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:40 2017/12/18
 * @modified by:
 */
public class GetFacesetsDetailInputModel extends CommonInputModel {

    private String facesetToken;
    private String start = "1";


    public String getFacesetToken() {
        return facesetToken;
    }

    public void setFacesetToken(String facesetToken) {
        this.facesetToken = facesetToken;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
