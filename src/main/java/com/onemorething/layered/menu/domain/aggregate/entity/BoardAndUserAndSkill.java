package com.onemorething.layered.menu.domain.aggregate.entity;


import java.util.List;

public class BoardAndUserAndSkill {

    private int boardSeq;
    private String title;
    private String threePoem;
    private int salary;
    private String profile;
    private String gitContribution;

    private User user;
    private int techSeq;
    private List<SkillAndTech> userSkills;

    public BoardAndUserAndSkill() {}

    public BoardAndUserAndSkill(int boardSeq, String title, String threePoem, int salary, String profile, String gitContribution, User user, int techSeq, List<SkillAndTech> userSkills) {
        this.boardSeq = boardSeq;
        this.title = title;
        this.threePoem = threePoem;
        this.salary = salary;
        this.profile = profile;
        this.gitContribution = gitContribution;
        this.user = user;
        this.techSeq = techSeq;
        this.userSkills = userSkills;
    }

    public int getBoardSeq() {
        return boardSeq;
    }

    public void setBoardSeq(int boardSeq) {
        this.boardSeq = boardSeq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThreePoem() {
        return threePoem;
    }

    public void setThreePoem(String threePoem) {
        this.threePoem = threePoem;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getGitContribution() {
        return gitContribution;
    }

    public void setGitContribution(String gitContribution) {
        this.gitContribution = gitContribution;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTechSeq() {
        return techSeq;
    }

    public void setTechSeq(int techSeq) {
        this.techSeq = techSeq;
    }

    public List<SkillAndTech> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(List<SkillAndTech> userSkills) {
        this.userSkills = userSkills;
    }
}

