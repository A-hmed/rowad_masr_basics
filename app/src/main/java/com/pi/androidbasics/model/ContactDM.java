package com.pi.androidbasics.model;

public class ContactDM {
    private int imageDrawableId;
    private String name;
    private String phoneNumber;

    public ContactDM(int imageDrawableId, String name, String phoneNumber) {
        this.imageDrawableId = imageDrawableId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public void setImageDrawableId(int imageDrawableId) {
        this.imageDrawableId = imageDrawableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
