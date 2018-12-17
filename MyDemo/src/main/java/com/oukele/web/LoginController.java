package com.oukele.web;

import com.oukele.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private StudentMapper studentMapper;
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("pwd") String pwd, Model model) {
        String forword = null;
        if (username.equals("oukele") && pwd.equals("oukele")) {

            model.addAttribute("student",studentMapper.getUserByIdForAnnotation("D331"));

            forword = "index";//登录成功跳转到index.jsp

        } else {
            System.out.println("no such user");
            forword = "Login";//登录失败跳转到Login.jsp继续登录操作
        }
        return forword;
    }
}
