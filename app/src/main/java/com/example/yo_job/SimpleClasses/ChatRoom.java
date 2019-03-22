package com.example.yo_job.SimpleClasses;

public class ChatRoom {
    private String name;
    private String profilePhoto;
    private String id;

    public ChatRoom() {
    }

    public ChatRoom(String name, String profilePhoto, String id) {
        this.name = name;
        this.profilePhoto = profilePhoto;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
