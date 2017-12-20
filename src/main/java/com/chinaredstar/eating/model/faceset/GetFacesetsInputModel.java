package com.chinaredstar.eating.model.faceset;

import com.chinaredstar.eating.model.common.CommonInputModel;

import javax.validation.constraints.Min;

/**
 * @description:
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:40 2017/12/18
 * @modified by:
 */
public class GetFacesetsInputModel extends CommonInputModel {

    private String tags;

    @Min(value = 1, message = "min is 1")
    private String start = "1";

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
