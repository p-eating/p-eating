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

    private String faceset_token;
    private String outer_id;

    private String face_added;
    private String face_count;

    private List<FailureDetailModel> failure_detail;


    public String getFaceset_token() {
        return faceset_token;
    }

    public void setFaceset_token(String faceset_token) {
        this.faceset_token = faceset_token;
    }

    public String getOuter_id() {
        return outer_id;
    }

    public void setOuter_id(String outer_id) {
        this.outer_id = outer_id;
    }

    public String getFace_added() {
        return face_added;
    }

    public void setFace_added(String face_added) {
        this.face_added = face_added;
    }

    public String getFace_count() {
        return face_count;
    }

    public void setFace_count(String face_count) {
        this.face_count = face_count;
    }

    public List<FailureDetailModel> getFailure_detail() {
        return failure_detail;
    }

    public void setFailure_detail(List<FailureDetailModel> failure_detail) {
        this.failure_detail = failure_detail;
    }


}
