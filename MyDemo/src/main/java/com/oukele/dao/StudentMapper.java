package com.oukele.dao;

import com.oukele.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {

    //使用xml配置文件
    Student getUserById(String number);
    //不使用配置文件使用注解
    @Select("Select * from student where number = #{number}")
    Student getUserByIdForAnnotation(String number);
    @Select("Select * from student where name = #{student.name} and age = #{student.age}")
    Student checkUser(@Param("student") Student student);
}
