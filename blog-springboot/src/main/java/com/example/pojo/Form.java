package com.example.pojo;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/8 15:05
 * @Version 1.0
 */

public class Form {
    private String username;
    private String name;
    private String city;
    private String college;
    private String major;
    private String phone;
    private Integer sex;
    private Integer smoke;
    private Integer clean;
    private Integer hulu;
    private Integer game;
    private String gameName;
    private Integer social;
    private Integer interest;
    private String interestName;
    private String introduction;
    private Integer smell;
    private Integer sleep;

    public Form() {
    }

    @Override
    public String toString() {
        return "Form{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", smoke=" + smoke +
                ", clean=" + clean +
                ", hulu=" + hulu +
                ", game=" + game +
                ", gameName='" + gameName + '\'' +
                ", social=" + social +
                ", interest=" + interest +
                ", interestName='" + interestName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", smell=" + smell +
                ", sleep=" + sleep +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getSmoke() {
        return smoke;
    }

    public void setSmoke(Integer smoke) {
        this.smoke = smoke;
    }

    public Integer getClean() {
        return clean;
    }

    public void setClean(Integer clean) {
        this.clean = clean;
    }

    public Integer getHulu() {
        return hulu;
    }

    public void setHulu(Integer hulu) {
        this.hulu = hulu;
    }

    public Integer getGame() {
        return game;
    }

    public void setGame(Integer game) {
        this.game = game;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Integer getSocial() {
        return social;
    }

    public void setSocial(Integer social) {
        this.social = social;
    }

    public Integer getInterest() {
        return interest;
    }

    public void setInterest(Integer interest) {
        this.interest = interest;
    }

    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getSmell() {
        return smell;
    }

    public void setSmell(Integer smell) {
        this.smell = smell;
    }

    public Integer getSleep() {
        return sleep;
    }

    public void setSleep(Integer sleep) {
        this.sleep = sleep;
    }

    public Form(String username, String name, String city, String college, String major, String phone, Integer sex, Integer smoke, Integer clean, Integer hulu, Integer game, String gameName, Integer social, Integer interest, String interestName, String introduction, Integer smell, Integer sleep) {
        this.username = username;
        this.name = name;
        this.city = city;
        this.college = college;
        this.major = major;
        this.phone = phone;
        this.sex = sex;
        this.smoke = smoke;
        this.clean = clean;
        this.hulu = hulu;
        this.game = game;
        this.gameName = gameName;
        this.social = social;
        this.interest = interest;
        this.interestName = interestName;
        this.introduction = introduction;
        this.smell = smell;
        this.sleep = sleep;
    }
}
