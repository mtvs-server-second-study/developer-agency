package com.onemorething.layered.menu.domain.aggregate.entity;

import java.util.Date;

public class Member {

    private String userEmail;
    private String userName;
    private String userPwd;
    private Date userBirth;
    private String userPhone;
    private String userTechStack1;
    private String userTechStack2;
    private String userTechStack3;

    public Member(String userEmail, String userName, String userPwd, Date userBirth, String userPhone, String userTechStack1, String userTechStack2, String userTechStack3) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userBirth = userBirth;
        this.userPhone = userPhone;
        this.userTechStack1 = userTechStack1;
        this.userTechStack2 = userTechStack2;
        this.userTechStack3 = userTechStack3;
    }

}
