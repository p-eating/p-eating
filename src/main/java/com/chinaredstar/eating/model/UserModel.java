package com.chinaredstar.eating.model;

import com.chinaredstar.eating.components.constants.FaceApiContants;
import com.chinaredstar.eating.model.common.CommonInputModel;

import java.io.Serializable;

/**
 * @description: 用户model
 * @author: chaoyue<chaoyue.fan @ chinaredstar.com>
 * @date: Create in 10:50 2017/12/19
 * @version: 1.0.0
 * @modified by:
 */
public class UserModel extends CommonInputModel implements Serializable {
    private static final long serialVersionUID = -4672836717435012491L;

    private String imageBase64 ;
    //用户名
    private String name;

    //性别
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}
