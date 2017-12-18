package com.chinaredstar.eating.model.faceset;

import com.chinaredstar.eating.model.common.CommonOutputModel;

import java.util.List;

/**
 * @description:
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:40 2017/12/18
 * @modified by:
 */
public class GetFacesetsOutputModel extends CommonOutputModel {

    private String next;
    private List<FacesetModel> facesets;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<FacesetModel> getFacesets() {
        return facesets;
    }

    public void setFacesets(List<FacesetModel> facesets) {
        this.facesets = facesets;
    }


}
