package com.example.controller;


import com.example.pojo.Form;
import com.example.pojo.Test;
import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/8 14:09
 * @Version 1.0
 */
@RestController
public class TestController {

    @Autowired
    TestService testService;

/*    @RequestMapping(value="/hello",method = RequestMethod.POST)
    public void Test01(HttpServletRequest res){
        Form form = new Form(res.getParameter("name"),res.getParameter("college"),Integer.parseInt(res.getParameter("sex")),Integer.parseInt(res.getParameter("smoke")),Integer.parseInt(res.getParameter("jiepi")),Integer.parseInt(res.getParameter("hulu")),Integer.parseInt(res.getParameter("youxi")),Integer.parseInt(res.getParameter("shejiao")));
        System.out.println(form.toString());


    }*/

    @RequestMapping("/test")
    public void Test02(){
        Test test = testService.SelectAll();
        System.out.println(test.getId());
    }
}
