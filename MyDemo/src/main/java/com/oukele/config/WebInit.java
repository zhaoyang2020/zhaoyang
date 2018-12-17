package com.oukele.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringWebConfig.class);//注册springWebConfig类
        ctx.setServletContext(servletContext);
        ServletRegistration.Dynamic dynamic =
                servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));//将 配置类 添加到DispatcherServlet上下文中
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
    }
}
