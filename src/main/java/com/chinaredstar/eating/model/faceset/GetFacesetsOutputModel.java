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
    private List<Faceset> facesets;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<Faceset> getFacesets() {
        return facesets;
    }

    public void setFacesets(List<Faceset> facesets) {
        this.facesets = facesets;
    }

    class Faceset {
        private String faceset_token;
        private String outer_id;
        private String display_name;
        private String tags;

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

        public String getDisplay_name() {
            return display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }
    }

}
