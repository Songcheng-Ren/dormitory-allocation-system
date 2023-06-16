package com.example.service;

import com.example.mapper.FormMapper;
import com.example.pojo.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/10 22:58
 * @Version 1.0
 */
@Service
public class FormService {
    @Autowired
    FormMapper formMapper;

    // 插入前端表单传来的值
    public void InsertNewFormRecord(Form form){
        formMapper.InsertNewFormRecord(form);
    }

    // 查找该用户资料
    public Form getDataByUsername(String username){
        return formMapper.queryDataByUsername(username);
    }

    // 查找用户资料是否已经存在
    public Integer queryDateIsExist(String username){

        return formMapper.queryDataIsExist(username);
    }

    // 查找其他表单
    public List<Form> getOtherForms(Form form) {
        return formMapper.getOtherForms(form);}
}
