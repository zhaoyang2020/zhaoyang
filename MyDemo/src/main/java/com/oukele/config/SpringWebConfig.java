package com.oukele.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration//声明当前类是一个配置类 类似于 ( spring-web.xml )
@EnableWebMvc//若无此注解 WebMvcConfigurer 接口 将无效
@ComponentScan("com.oukele")//自动扫描spring注解 比如@Service、@Component、@Repository和@Controller的类，并注册为Bean
public class SpringWebConfig implements WebMvcConfigurer {

    //添加一个ViewResolver 解析 view
    @Bean//相当于Spring配置文件bean节点
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }
    //注册静态资源，比如（css,js,.....）
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/fonts/");
    }

    //根目录直接跳转到登录页面 Login.jsp
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("Login");
    }
}
