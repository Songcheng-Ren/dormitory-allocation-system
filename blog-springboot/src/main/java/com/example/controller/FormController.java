package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.Client;
import com.example.pojo.Form;
import com.example.pojo.Result;
import com.example.service.FormService;
import org.apache.ibatis.annotations.Param;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/10 23:00
 * @Version 1.0
 */
@RestController
public class FormController {
    @Autowired
    FormService formService;

    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public Boolean InsertNewFormRecord(HttpServletRequest req){

        String username = req.getParameter("username");
        // 验证是否填写过资料
        if(formService.queryDateIsExist(username)>0){
            return false;
        }else{
        String name = req.getParameter("name");
        String college = req.getParameter("college");
        String major = req.getParameter("major");
        String city = req.getParameter("city");
        String phone = req.getParameter("phone");
        int sex = Integer.parseInt(req.getParameter("sex"));
        int smoke = Integer.parseInt(req.getParameter("smoke"));
        int clean = Integer.parseInt(req.getParameter("clean"));
        int hulu = Integer.parseInt(req.getParameter("hulu"));
        int game = Integer.parseInt(req.getParameter("game"));
        int social = Integer.parseInt(req.getParameter("social"));
        int interest = Integer.parseInt(req.getParameter("interest"));
        int smell = Integer.parseInt(req.getParameter("smell"));
        String introduction = req.getParameter("introduction");
        int sleep = Integer.parseInt(req.getParameter("sleep"));
        String gameName = req.getParameter("gameName");
        String interestName = req.getParameter("interestName");
        Form form  = new Form(username,name,city,college,major,phone,sex,smoke,clean,hulu,game,gameName,social,interest,interestName,introduction,smell,sleep);

        formService.InsertNewFormRecord(form);
        System.out.println("插入数据成功");

        return true;
        }
    }
    // 此处调用查询函数，封装成username+name+phone形式返回
    @RequestMapping("/getResult")
    public String getResult(HttpServletRequest req) throws Exception {
        String username = req.getParameter("username");
        Form dataByUsername = formService.getDataByUsername(username);
        List<String> tops = recommendRoommates(dataByUsername);
        List<Result> res = new ArrayList<>();
        for(String top : tops) {
            Form it = formService.getDataByUsername(top);
            res.add(new Result(it.getUsername(), it.getName(), it.getPhone()));
        }
        return JSON.toJSONString(res);
    }

    public List<String> recommendRoommates(Form user) throws Exception {
        Map<String, Double> map = new HashMap<>();
        List<Form> others = formService.getOtherForms(user);
        String city = user.getCity();
        List<Integer> userChoices = new ArrayList<>();
        String userText = user.getGameName() + user.getInterestName() + user.getIntroduction();
        userChoices.add(user.getSmoke());
        userChoices.add(user.getClean());
        userChoices.add(user.getHulu());
        userChoices.add(user.getGame());
        userChoices.add(user.getSocial());
        userChoices.add(user.getInterest());
        userChoices.add(user.getSmell());
        userChoices.add(user.getSleep());

        for(Form other : others) {
            List<Integer> otherChoices = new ArrayList<>();
            String otherText = other.getGameName() + other.getInterestName() + other.getIntroduction();
            double score = 0;
            otherChoices.add(other.getSmoke());
            otherChoices.add(other.getClean());
            otherChoices.add(other.getHulu());
            otherChoices.add(other.getGame());
            otherChoices.add(other.getSocial());
            otherChoices.add(other.getInterest());
            otherChoices.add(other.getSmell());
            otherChoices.add(other.getSleep());
            score = Client.getSimilarity(userChoices, userText, otherChoices, otherText);
            if(city.equals(other.getCity())) score += 0.1;
            map.put(other.getUsername(), score);
        }
        return sortMap(map);
    }
    public List<String> sortMap(Map<String, Double> map) {
        List<String> result = new ArrayList<String>();
        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet()); //将map的entryset放入list集合
        list.sort(new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(int i = 0; i < ((list.size() < 3) ? list.size() : 3); i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }
}
