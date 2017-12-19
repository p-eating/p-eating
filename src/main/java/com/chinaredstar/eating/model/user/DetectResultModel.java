package com.chinaredstar.eating.model.user;

import com.chinaredstar.eating.model.common.CommonOutputModel;

import java.util.List;

/**
 * @description: 上传图片返回model
 * @author: chaoyue<chaoyue.fan @ chinaredstar.com>
 * @date: Create in 10:50 2017/12/19
 * @version: 1.0.0
 * @modified by:
 */
public class DetectResultModel extends CommonOutputModel{

    private String imageId;

    private List<DetectFaceResultModel> faces;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public List<DetectFaceResultModel> getFaces() {
        return faces;
    }

    public void setFaces(List<DetectFaceResultModel> faces) {
        this.faces = faces;
    }
}
