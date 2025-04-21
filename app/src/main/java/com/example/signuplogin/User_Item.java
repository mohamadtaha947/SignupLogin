package com.example.signuplogin;

import android.os.Parcelable;

public abstract class User_Item implements Parcelable {
    private String id;
    private String FirstName;
    private String LastName;
    private String BirthDate;
    private String phone;
    private String UserName;
    private String Photo;

    public User_Item(String firstName, String id, String photo, String userName, String lastName, String phone, String birthDate) {
        FirstName = firstName;
        this.id = id;
        Photo = photo;
        UserName = userName;
        LastName = lastName;
        this.phone = phone;
        BirthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User_Item{" +
                "id='" + id + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", BirthDate='" + BirthDate + '\'' +
                ", phone='" + phone + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Photo='" + Photo + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
}

