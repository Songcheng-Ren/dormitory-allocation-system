package com.example.mapper;

import com.example.pojo.Form;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/10 22:49
 * @Version 1.0
 */
@Mapper
public interface FormMapper {

    // 插入表单值
    void InsertNewFormRecord(Form form);

    // 查找该用户资料
    Form queryDataByUsername(String username);

    // 查找资料是否已经存在
    Integer queryDataIsExist(String username);

    // 查询其他表单
    List<Form> getOtherForms(Form form);

}
