package com.chinaredstar.eating.model.common;


import com.chinaredstar.eating.components.constants.FaceApiContants;

/**
 * @description: face++ api公共入参
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:37 2017/12/18
 * @modified by:
 */
public class CommonInputModel {


    private String apiKey = FaceApiContants.API_KEY;

    private String apiSecret = FaceApiContants.API_SECRET;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

}
