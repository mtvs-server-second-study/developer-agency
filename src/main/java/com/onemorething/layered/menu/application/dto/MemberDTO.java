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
    private String userTech2;
    private String userTech3;

    public MemberDTO(String userEmail, String userName, String userPwd, Date userBirth, String userPhone, String userTech1, String userTech2, String userTech3) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userBirth = userBirth;
        this.userPhone = userPhone;
        this.userTech1 = userTech1;
        this.userTech2 = userTech2;
        this.userTech3 = userTech3;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserTech1() {
        return userTech1;
    }

    public void setUserTech1(String userTech1) {
        this.userTech1 = userTech1;
    }

    public String getUserTech2() {
        return userTech2;
    }

    public void setUserTech2(String userTech2) {
        this.userTech2 = userTech2;
    }

    public String getUserTech3() {
        return userTech3;
    }

    public void setUserTech3(String userTech3) {
        this.userTech3 = userTech3;
    }
    private String UserTech2;
    private String UserTech3;

}
