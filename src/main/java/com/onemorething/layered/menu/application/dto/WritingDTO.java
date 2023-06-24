package com.onemorething.layered.menu.application.dto;

public class WritingDTO {

    private String profile; // 프로필 사진
    private String title;   // 글쓰기 제목
    private String content; // 글쓰기 내용

    public WritingDTO() {}

    public WritingDTO(String profile, String title, String content) {
        this.profile = profile;
        this.title = title;
        this.content = content;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "WritingDTO{" +
                "profile='" + profile + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
