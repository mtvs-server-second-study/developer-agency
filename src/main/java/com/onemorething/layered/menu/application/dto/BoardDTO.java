package com.onemorething.layered.menu.application.dto;

public class BoardDTO {

    private String userEmail;       /* 로그인 된 유저 이메일 */
    private String title;           /* 인생 명언 */
    private String threePoem;       /* 삼행시 */
    private int salary;             /* 희망 연봉 */
    private String profile;         /* 프로필 사진 경로 */
    private String gitContribution; /* 깃허브 잔디 사진 경로 */

    public BoardDTO(String userEmail, String title, String threePoem, int salary, String profile, String gitContribution) {
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
