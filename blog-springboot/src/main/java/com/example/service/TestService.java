package com.example.service;

import com.example.mapper.TestMapper;
import com.example.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/9 23:01
 * @Version 1.0
 */
@Service
public class TestService {
    @Autowired
    TestMapper testMapper;

    public Test SelectAll(){
        return testMapper.selectAll();
    }
}
