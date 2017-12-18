package com.chinaredstar.eating.model;

import java.io.Serializable;

public class UserModel implements Serializable {
    private static final long serialVersionUID = -4672836717435012491L;

    private Long id;

    private String name;

    private int gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
