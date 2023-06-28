package com.onemorething.layered.menu.application.dto;

public class TechDTO {

    private int techSeq;
    private String techName;

    public TechDTO() {}

    public TechDTO(int techSeq, String techName) {
        this.techSeq = techSeq;
        this.techName = techName;
    }

    public int getTechSeq() {
        return techSeq;
    }

    public void setTechSeq(int techSeq) {
        this.techSeq = techSeq;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }
}
