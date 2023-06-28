package com.onemorething.layered.menu.domain.aggregate.entity;

public class Board {

    private String userEmail;
    private String title;   // 설명. 인생 명언
    private String threePoem;   // 설명. 삼행시
    private int salary; // 설명. 희망 연봉
    private String profile; // 설명. 프로필 사진 경로
    private String gitContribution; // 설명. 깃허브 잔디 사진 경로

    public Board(String userEmail, String title, String threePoem, int salary, String profile, String gitContribution) {
        this.userEmail = userEmail;
        this.title = title;
        this.threePoem = threePoem;
        this.salary = salary;
        this.profile = profile;
        this.gitContribution = gitContribution;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getTitle() {
        return title;
    }

    public String getThreePoem() {
        return threePoem;
    }

    public int getSalary() {
        return salary;
    }

    public String getProfile() {
        return profile;
    }

    public String getGitContribution() {
        return gitContribution;
    }
}
