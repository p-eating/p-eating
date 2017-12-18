package com.chinaredstar.eating.model.faceset;

import com.chinaredstar.eating.model.common.CommonInputModel;

/**
 * @description:
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:40 2017/12/18
 * @modified by:
 */
public class CreateFacesetInputModel extends CommonInputModel {

    private String display_name;
    private String outer_id;
    private String tags;
    private String face_tokens;
    private String user_data;
    private String force_merge = "0";


    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getOuter_id() {
        return outer_id;
    }

    public void setOuter_id(String outer_id) {
        this.outer_id = outer_id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getFace_tokens() {
        return face_tokens;
    }

    public void setFace_tokens(String face_tokens) {
        this.face_tokens = face_tokens;
    }

    public String getUser_data() {
        return user_data;
    }

    public void setUser_data(String user_data) {
        this.user_data = user_data;
    }

    public String getForce_merge() {
        return force_merge;
    }

    public void setForce_merge(String force_merge) {
        this.force_merge = force_merge;
    }
}
