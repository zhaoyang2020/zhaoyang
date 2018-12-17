package com.oukele.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration//声明当前类是一个配置类
public class SpringDaoConfig {
    @Bean
    public DataSource dataSource() throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/test");
        dataSource.setDriverClass("org.mariadb.jdbc.Driver");
        dataSource.setUser("oukele");
        dataSource.setPassword("oukele");

        return dataSource;
    }
    /*@Bean(name = "sqlSessionFactory") 如果不写就默认方法的名字*/
    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory() throws PropertyVetoException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

        ClassPathResource resource = new ClassPathResource("mapper/StudentMapper.xml");
        sqlSessionFactory.setTypeAliasesPackage("com.oukele.entity");
        sqlSessionFactory.setMapperLocations(new Resource[]{resource});
        sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        sqlSessionFactory.setDataSource(this.dataSource());
        return sqlSessionFactory;
    }
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        configurer.setBasePackage("com.oukele.dao");
        return configurer;
    }
}
