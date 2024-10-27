package com.example.signuplogin;

public class User {
    private String id;
    private String FirstName;
    private String LastName;
    private String BirthDate;
    private String phone;
    private String UserName;
    private String Photo;

    public User() {
    }

    public User(String photo, String userName, String phone, String birthDate, String lastName, String firstName, String id) {
        Photo = photo;
        UserName = userName;
        this.phone = phone;
        BirthDate = birthDate;
        LastName = lastName;
        FirstName = firstName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", BirthDate='" + BirthDate + '\'' +
                ", phone='" + phone + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Photo='" + Photo + '\'' +
                '}';
    }
}
