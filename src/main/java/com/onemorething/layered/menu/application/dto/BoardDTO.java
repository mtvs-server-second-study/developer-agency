package com.onemorething.layered.menu.application.dto;

public class BoardDTO {

    private String userEmail;       /* 로그인 된 유저 이메일 */
    private String title;           /* 인생 명언 */
    private String threePoem;       /* 삼행시 */
    private int salary;             /* 희망 연봉 */
    private String profile;         /* 프로필 사진 경로 */
    private String gitContribution; /* 깃허브 잔디 사진 경로 */

    public BoardDTO() {}

    public BoardDTO(String userEmail, String title, String threePoem, int salary, String profile, String gitContribution) {
        this.userEmail = userEmail;
        this.title = title;
        this.threePoem = threePoem;
        this.salary = salary;
        this.profile = profile;
        this.gitContribution = gitContribution;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setThreePoem(String threePoem) {
        this.threePoem = threePoem;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setGitContribution(String gitContribution) {
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

    @Override
    public String toString() {
        return "BoardDTO{" +
                "userEmail='" + userEmail + '\'' +
                ", title='" + title + '\'' +
                ", threePoem='" + threePoem + '\'' +
                ", salary=" + salary +
                ", profile='" + profile + '\'' +
                ", gitContribution='" + gitContribution + '\'' +
                '}';
    }
}
