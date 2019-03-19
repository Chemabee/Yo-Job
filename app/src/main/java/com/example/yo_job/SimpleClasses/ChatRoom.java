package com.example.yo_job.SimpleClasses;

public class ChatRoom {
    private String name;
    private String profilePhoto;

    public ChatRoom() {
    }

    public ChatRoom(String name, String profilePhoto) {
        this.name = name;
        this.profilePhoto = profilePhoto;
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
}
