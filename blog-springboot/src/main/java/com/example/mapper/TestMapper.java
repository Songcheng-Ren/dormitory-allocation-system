package com.example.mapper;

import com.example.pojo.Test;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Description
 * @Author LZ.
 * @Date 2022/11/9 22:48
 * @Version 1.0
 */
@Mapper
public interface TestMapper {

   Test selectAll();


}
