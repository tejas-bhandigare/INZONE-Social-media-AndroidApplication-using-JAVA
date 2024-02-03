package com.example.project;

public class user_profile {
    private String Username, UserBio;

    public user_profile() {

    }

    public user_profile(String username, String userBio) {
        Username = username;
        UserBio = userBio;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getUserBio() {
        return UserBio;
    }

    public void setUserBio(String userBio) {
        UserBio = userBio;
    }
}

