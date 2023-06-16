package com.example.pojo;

import java.util.Objects;

public class Result {
    private String username;
    private String name;
    private String phone;

    public Result(String username, String name, String phone) {
        this.username = username;
        this.name = name;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(username, result.username) && Objects.equals(name, result.name) && Objects.equals(phone, result.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name, phone);
    }

    @Override
    public String toString() {
        return "Result{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
