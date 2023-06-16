package com.example.mapper;

import com.example.pojo.User_info;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/16 17:20
 * @Version 1.0
 */
@Mapper
public interface UserInfoMapper {

    //插入新用户资料
    void insertInfo(User_info userInfo);

    // 查询用户资料
    User_info queryInfo(String username);

    // 查询记录是否已经存在
    int checkRecordIsExist(String username);

    // 删除该条记录
    void deleteByUsername(String username);

}
