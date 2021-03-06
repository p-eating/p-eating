package com.chinaredstar.eating.model.faceset;

import com.chinaredstar.eating.model.common.CommonInputModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @description:
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:40 2017/12/18
 * @modified by:
 */
public class GetFacesetsDetailInputModel extends CommonInputModel {

    @NotNull(message = "不能为空")
    private String facesetToken;

    @Min(value = 1, message = "min is 1")
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
