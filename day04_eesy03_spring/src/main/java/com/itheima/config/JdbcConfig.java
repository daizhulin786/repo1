package com.itheima.config;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcConfig {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String password;
    @Bean(name="jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return  new JdbcTemplate(dataSource);
    }
    @Bean(name="dataSource")
    public DataSource createDateSource(){
        DriverManagerDataSource dm=new DriverManagerDataSource();
        dm.setJdbcUrl(url);
        dm.setDriverClass(driver);
        dm.setUser(user);
        dm.setPassword(password);
        return dm;
    }
}
