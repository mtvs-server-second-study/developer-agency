package com.onemorething.layered.menu.domain.aggregate.entity;

public class Tech {

    private String techName;

    public Tech(String techName) {
        this.techName = techName;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }
}
