package com.chinaredstar.eating.model;

public class EatingUserFaceModel {
    private Long id;

    private Long userId;

    private String faceToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken == null ? null : faceToken.trim();
    }
}