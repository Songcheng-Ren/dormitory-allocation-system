package com.example.pojo;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/13 14:58
 * @Version 1.0
 */
public class User_auth {
    private String userId;
    private String userPassword;
    private String userEmail;

    public User_auth(String userId, String userPassword, String userEmail) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public User_auth() {
    }

    public String getUserId() {
        return userId;
    }

    public User_auth setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public User_auth setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public User_auth setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    @Override
    public String toString() {
        return "User_auth{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
