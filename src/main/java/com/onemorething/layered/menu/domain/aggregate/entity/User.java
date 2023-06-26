package com.onemorething.layered.menu.domain.aggregate.entity;

import com.onemorething.layered.menu.application.dto.UserDTO;

public class User {

    private String userEmail;
    private String userName;
    private String userPwd;
    private String userBirth;
    private String userPhone;
    private String userTechStack1;
    private String userTechStack2;
    private String userTechStack3;

    //회원가입시 UserDTO > user (entity)변환용으로 활용
    public User(UserDTO userDTO){
        this.userEmail=userDTO.getUserEmail();
        this.userName=userDTO.getUserName();
        this.userPwd=userDTO.getUserPwd();
        this.userBirth=userDTO.getUserBirth();
        this.userPhone=userDTO.getUserPhone();
        this.userTechStack1=userDTO.getUserTech1();
        this.userTechStack2=userDTO.getUserTech2();
        this.userTechStack3=userDTO.getUserTech3();
    }

    public User(String userEmail, String userName, String userPwd, String userBirth, String userPhone, String userTechStack1, String userTechStack2, String userTechStack3) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userBirth = userBirth;
        this.userPhone = userPhone;
        this.userTechStack1 = userTechStack1;
        this.userTechStack2 = userTechStack2;
        this.userTechStack3 = userTechStack3;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserTechStack1() {
        return userTechStack1;
    }

    public String getUserTechStack2() {
        return userTechStack2;
    }

    public String getUserTechStack3() {
        return userTechStack3;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserTechStack1(String userTechStack1) {
        this.userTechStack1 = userTechStack1;
    }

    public void setUserTechStack2(String userTechStack2) {
        this.userTechStack2 = userTechStack2;
    }

    public void setUserTechStack3(String userTechStack3) {
        this.userTechStack3 = userTechStack3;
    }

    @Override
    public String toString() {
        return "User{" +
                "userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userTechStack1='" + userTechStack1 + '\'' +
                ", userTechStack2='" + userTechStack2 + '\'' +
                ", userTechStack3='" + userTechStack3 + '\'' +
                '}';
    }
}
