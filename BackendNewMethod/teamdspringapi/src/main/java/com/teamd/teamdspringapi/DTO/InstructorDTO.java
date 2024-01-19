package com.teamd.teamdspringapi.DTO;

public class InstructorDTO {
    private Long UserID;
    private String full_name;
    private String username;
    private String email;
    private String password;
    private String profile;

    public Long getUserID() {
        return this.UserID;
    }

    public void setUserID(Long UserID) {
        this.UserID = UserID;
    }

    public String getFull_name() {
        return this.full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


}
