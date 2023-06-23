package com.onemorething.layered.menu.application.dto;

import java.util.Date;

public class MemberDTO {

    private String userEmail;
    private String userName;
    private String userPwd;
    private String userCheckPwd;
    private Date userBirth;
    private String userPhone;
    private String userTech1;
    private String UserTech2;
    private String UserTech3;

    public MemberDTO() {}

    public String getuserEmail() {
        return userEmail;
    }

    public void setuserEmail(String email) {
        this.userEmail = email;
    }

}
