package com.example.project;


import java.util.List;

public class Post {
    private String postId;
    private String userId;
    private String caption;
    private String imageUrl;


    // Default constructor required for Firebase
    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }



    public Post(String postId, String userId, String caption, String imageUrl) {
        this.postId = postId;
        this.userId = userId;
        this.caption = caption;
        this.imageUrl = imageUrl;

    }

    // Getters and setters
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
