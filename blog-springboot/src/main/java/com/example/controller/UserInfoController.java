package com.example.controller;

import com.example.pojo.User_info;
import com.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/16 17:29
 * @Version 1.0
 */
@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    // 插入用户资料
    @RequestMapping("/insertInfo")
    public void insertInfo(HttpServletRequest req){
        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String city = req.getParameter("city");
        String collage = req.getParameter("collage");
        String major = req.getParameter("major");
        String email = req.getParameter("email");
        String introduction = req.getParameter("introduction");
        String phone = req.getParameter("phone");

        User_info userInfo = new User_info(username,name,Integer.parseInt(sex),city,collage,major,email,introduction,phone);

        System.out.println(userInfo);
        if(userInfoService.checkRecordIsExist(username) > 0){
            // 先删除再更新
            userInfoService.deleteByUsername(username);
            userInfoService.insertInfo(userInfo);
        }else{
            // 插入新的数据
            userInfoService.insertInfo(userInfo);
            System.out.println("数据插入成功");
        }



    }

    // 查询用户资料
    @RequestMapping("/queryInfo")
    public User_info queryInfo(HttpServletRequest req){
        String username = req.getParameter("username");
        System.out.println(username);
        System.out.println(userInfoService.queryInfo(username));
        return userInfoService.queryInfo(username);
    }

    // 查询记录是否已经存在
    @RequestMapping("/checkRecordIsExist")
    public Boolean checkRecordIsExist(HttpServletRequest req){
        String username = req.getParameter("username");
        return userInfoService.checkRecordIsExist(username) > 0;
    }
}
