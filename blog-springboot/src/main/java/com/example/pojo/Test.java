package com.example.pojo;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/9 23:19
 * @Version 1.0
 */
public class Test {
    private String name;
    private Integer id;

    public Test(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Test() {
    }

    public String getName() {
        return name;
    }

    public Test setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Test setId(Integer id) {
        this.id = id;
        return this;
    }
}
