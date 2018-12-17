package com.oukele;

import com.oukele.config.SpringDaoConfig;
import com.oukele.dao.StudentMapper;
import com.oukele.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringDaoConfig.class})
public class StudentTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void getIdInfo(){
        Student student = studentMapper.getUserById("A101");
        System.out.println(student);
    }
    @Test
    public void getName(){
        Student student = studentMapper.getUserByIdForAnnotation("B211");
        System.out.println(student);
    }

    @Test
    public void getNameAndSex(){
        Student student = new Student();
        student.setName("小兰");
        student.setAge(18);
        Student result = studentMapper.checkUser(student);
        System.out.println(result);
    }
}
