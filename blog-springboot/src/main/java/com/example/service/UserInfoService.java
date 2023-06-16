package com.example.service;

import com.example.mapper.UserInfoMapper;
import com.example.pojo.User_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/16 17:27
 * @Version 1.0
 */
@Service
public class UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    // 插入新用户资料
    public void insertInfo(User_info userInfo){
        userInfoMapper.insertInfo(userInfo);
    }

    // 查询用户资料
    public User_info queryInfo(String username){
        return userInfoMapper.queryInfo(username);
    }

    // 查询记录是否已经存在
    public int checkRecordIsExist(String username){
        return userInfoMapper.checkRecordIsExist(username);
    }

    // 删除一条数据
    public void deleteByUsername(String username){
        userInfoMapper.deleteByUsername(username);
    }
}
