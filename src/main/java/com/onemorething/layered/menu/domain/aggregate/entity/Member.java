package com.onemorething.layered.menu.domain.aggregate.entity;

import java.util.Date;

public class Member {

    private String userEmail;
    private String userName;
    private String userPwd;
    private String userBirth;
    private String userPhone;
    private String userTechStack1;
    private String userTechStack2;
    private String userTechStack3;

    public Member(String userEmail, String userName, String userPwd, String userBirth, String userPhone, String userTechStack1, String userTechStack2, String userTechStack3) {
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
}
