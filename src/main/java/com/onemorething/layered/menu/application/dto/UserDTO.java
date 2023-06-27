package com.onemorething.layered.menu.application.dto;

import com.onemorething.layered.menu.domain.aggregate.entity.User;
import com.onemorething.layered.menu.domain.aggregate.enumtype.Proficiency;

import java.util.List;

public class UserDTO {

    private String userEmail;
    private String userName;
    private String userPwd;
    private String userCheckPwd;
    private String userBirth;
    private String userPhone;
    private List<String> userTech;
    private List<Proficiency> proficiency;

    public UserDTO() {}

    public UserDTO(String userEmail, String userName, String userPwd, String userCheckPwd, String userBirth, String userPhone, List<String> userTech, List<Proficiency> proficiency) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userCheckPwd = userCheckPwd;
        this.userBirth = userBirth;
        this.userPhone = userPhone;
        this.userTech = userTech;
        this.proficiency = proficiency;
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

    public String getUserCheckPwd() {
        return userCheckPwd;
    }

    public void setUserCheckPwd(String userCheckPwd) {
        this.userCheckPwd = userCheckPwd;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public List<String> getUserTech() {
        return userTech;
    }

    public void setUserTech(List<String> userTech) {
        this.userTech = userTech;
    }

    public List<Proficiency> getProficiency() {
        return proficiency;
    }

    public void setProficiency(List<Proficiency> proficiency) {
        this.proficiency = proficiency;
    }
}