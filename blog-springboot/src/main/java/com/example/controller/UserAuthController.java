package com.example.controller;

import com.example.service.UserAuthService;
import org.apache.catalina.session.StandardSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/13 15:15
 * @Version 1.0
 */
@RestController
public class UserAuthController {
    @Autowired
    UserAuthService userAuthService;

    @RequestMapping(value = "/login")
    public Boolean checkUsernameAndPassword(HttpServletRequest req){


        String username = req.getParameter("Username");
        String password = req.getParameter("Password");
        Integer flag = userAuthService.checkUsernameAndPassword(username, password);
        System.out.println(username+password);

        return flag > 0;
    }

    @RequestMapping(value="/register")
    public Boolean register(HttpServletRequest req){
        String username = req.getParameter("Username");
        String password = req.getParameter("Password");
        String email = req.getParameter("email");
        if(userAuthService.checkUsernameExist(username) > 0){
            return false;
        }
        else{
            userAuthService.register(username,password,email);
            System.out.println(username+password+email);
            return true;
        }
    }

    @RequestMapping(value="/checkDataFlag")
    public Boolean checkDataIsSet(HttpServletRequest req){
        String username = req.getParameter("username");
        System.out.println(username);
        return userAuthService.checkDataIsSet(username) == 1;
    }

    @RequestMapping(value = "/setDataFlag")
    public void setDataFlag(HttpServletRequest req){
        String username = req.getParameter("username");
        userAuthService.setDataFlag(username);
    }
}
