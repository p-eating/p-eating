package com.chinaredstar.eating.model.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 配置类
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 18:08 2017/12/18
 * @modified by:
 */
@Configuration
@ConfigurationProperties(prefix = "face.api")
public class FaceApiConfigModel {

    private String key;
    private String secret;
    private String facesetToken;


    public String getFacesetToken() {
        return facesetToken;
    }

    public void setFacesetToken(String facesetToken) {
        this.facesetToken = facesetToken;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
