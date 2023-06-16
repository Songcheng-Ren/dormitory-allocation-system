package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/13 15:02
 * @Version 1.0
 */
@Mapper
public interface UserAuthMapper {

    // 登录检验用户名和密码
    int checkUsernameAndPsd(String username, String password);

    // 注册新用户
    void register(String username, String password, String email);

    //查验用户名是否存在
    int checkUsernameExist(String username);

    //    进入主页后查验是否已经填写个人资料
    int checkDataIsSet(String username);

    // 设置flag
    void setDataFlag(String username);
}
