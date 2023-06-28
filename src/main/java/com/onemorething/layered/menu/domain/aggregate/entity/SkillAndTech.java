package com.onemorething.layered.menu.domain.aggregate.entity;

import com.onemorething.layered.menu.domain.aggregate.enumtype.Proficiency;

import java.util.List;

public class SkillAndTech {

    private String userEmail;
    private int techSeq;
    private List<String> userTech;
    private List<Proficiency> proficiency;
    private String userSkill;
    private Proficiency userProficiency;

    public SkillAndTech() {}

    public SkillAndTech(String userEmail, int techSeq, List<String> userTech, List<Proficiency> proficiency, String userSkill, Proficiency userProficiency) {
        this.userEmail = userEmail;
        this.techSeq = techSeq;
        this.userTech = userTech;
        this.proficiency = proficiency;
        this.userSkill = userSkill;
        this.userProficiency = userProficiency;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getTechSeq() {
        return techSeq;
    }

    public List<String> getUserTech() {
        return userTech;
    }

    public void setUserTech(List<String> userTech) {
        this.userTech = userTech;
    }

    public List<Proficiency> getProficiency() {
        return proficiency;
    }

    public void setProficiency(List<Proficiency> proficiency) {
        this.proficiency = proficiency;
    }

    public String getUserSkill() {
        return userSkill;
    }


    public Proficiency getUserProficiency() {
        return userProficiency;
    }

}

