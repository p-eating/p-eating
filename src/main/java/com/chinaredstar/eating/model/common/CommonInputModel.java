package com.chinaredstar.eating.model.common;


import com.chinaredstar.eating.components.constants.FaceApiContants;

/**
 * @description: face++ api公共入参
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:37 2017/12/18
 * @modified by:
 */
public class CommonInputModel {


    private String api_key = FaceApiContants.API_KEY;

    private String api_secret = FaceApiContants.API_SECRET;

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getApi_secret() {
        return api_secret;
    }

    public void setApi_secret(String api_secret) {
        this.api_secret = api_secret;
    }
}
