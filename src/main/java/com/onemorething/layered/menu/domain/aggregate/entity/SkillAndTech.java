package com.onemorething.layered.menu.domain.aggregate.entity;

import com.onemorething.layered.menu.domain.aggregate.enumtype.Proficiency;

import java.util.List;

public class SkillAndTech {

    private String userEmail;
    private Tech tech;
    private List<String> userTech;
    private List<Proficiency> proficiency;
    private String userSkill;
    private Proficiency userProficiency;

    public SkillAndTech() {}

    public SkillAndTech(String userEmail, Tech tech, List<String> userTech, List<Proficiency> proficiency, String userSkill, Proficiency userProficiency) {
        this.userEmail = userEmail;
        this.tech = tech;
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

    public Tech getTech() {
        return tech;
    }

    public void setTech(Tech tech) {
        this.tech = tech;
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

    public void setUserSkill(String userSkill) {
        this.userSkill = userSkill;
    }

    public Proficiency getUserProficiency() {
        return userProficiency;
    }

    public void setUserProficiency(Proficiency userProficiency) {
        this.userProficiency = userProficiency;
    }
}

