package com.onemorething.layered.menu.domain.aggregate.entity;

import com.onemorething.layered.menu.domain.aggregate.enumtype.Proficiency;

public class Skill {

    private String userEmail;
    private String userTech;
    private Proficiency userProficiency;

    public Skill() {}

    public Skill(String userEmail, String userTech, Proficiency userProficiency) {
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


    public Proficiency getUserProficiency() {
        return userProficiency;
    }

}
