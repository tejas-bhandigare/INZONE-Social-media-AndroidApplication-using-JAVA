package com.example.admin;

public class UserInfo {
    private String userId;
    private String username;
    private String bio;
    private String email;




    public UserInfo() {
    }



    public UserInfo(String userId, String username, String bio, String email ){
        this.userId = userId;
        this.username = username;
        this.bio = bio;
        this.email = email;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
