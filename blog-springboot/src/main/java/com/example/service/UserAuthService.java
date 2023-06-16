package com.example.service;

import com.example.mapper.UserAuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/13 15:00
 * @Version 1.0
 */
@Service
public class UserAuthService {
    @Autowired
    UserAuthMapper userAuthMapper;

//    登录检验用户名和密码
    public Integer checkUsernameAndPassword(String username, String password){
        return userAuthMapper.checkUsernameAndPsd(username, password);
    }

//    注册
    public void register(String username,String password,String email){
        userAuthMapper.register(username, password, email);
    }

//    查验用户名是否已经存在
    public int checkUsernameExist(String username){
        return userAuthMapper.checkUsernameExist(username);
    }

//    进入主页后查验是否已经填写个人资料
    public int checkDataIsSet(String username){
        return userAuthMapper.checkDataIsSet(username);
    }
//   设置flag
    public void setDataFlag(String username){
        userAuthMapper.setDataFlag(username);
    }
}
