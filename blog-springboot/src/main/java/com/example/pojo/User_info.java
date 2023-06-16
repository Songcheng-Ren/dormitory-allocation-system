package com.example.pojo;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/16 17:17
 * @Version 1.0
 */
public class User_info {
    private String username;
    private String name;
    private Integer sex;
    private String city;
    private String collage;
    private String major;
    private String email;
    private String introduction;
    private String phone;

    public String getUsername() {
        return username;
    }

    public User_info setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getName() {
        return name;
    }

    public User_info setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public User_info setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getCity() {
        return city;
    }

    public User_info setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCollage() {
        return collage;
    }

    public User_info setCollage(String collage) {
        this.collage = collage;
        return this;
    }

    public String getMajor() {
        return major;
    }

    public User_info setMajor(String major) {
        this.major = major;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User_info setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public User_info setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User_info setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public User_info() {
    }

    public User_info(String username, String name, Integer sex, String city, String collage, String major, String email, String introduction, String phone) {
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.city = city;
        this.collage = collage;
        this.major = major;
        this.email = email;
        this.introduction = introduction;
        this.phone = phone;
    }
}
