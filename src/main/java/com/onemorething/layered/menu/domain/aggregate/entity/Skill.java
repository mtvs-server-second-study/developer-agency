package com.onemorething.layered.menu.domain.aggregate.entity;

public class Skill {

    private String userEmail;
    private String userTech;
    private String userProficiency;

    public Skill() {}

    public Skill(String userEmail, String userTech, String userProficiency) {
        this.userEmail = userEmail;
        this.userTech = userTech;
        this.userProficiency = userProficiency;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTech() {
        return userTech;
    }

    public void setUserTech(String userTech) {
        this.userTech = userTech;
    }

    public String getUserProficiency() {
        return userProficiency;
    }

    public void setUserProficiency(String userProficiency) {
        this.userProficiency = userProficiency;
    }
}
