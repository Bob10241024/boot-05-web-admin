package com.atguigu.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Deprecated
//@Configuration
public class MyDataSourceConfig {

    //默认的自动配置是判断容器中没有才会配@ConditionalOnMissingBean(type = {"io.r2dbc.spi.ConnectionFactory"})
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
    public DataSource dataSource() throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();
        //加入监控功能  可以在yaml配置文件里面写这些
//        druidDataSource.setFilters("stat,wall");

//        druidDataSource.setUrl();
//        druidDataSource.setUsername();
//        druidDataSource.setPassword();
//        druidDataSource.setDriverClassName();

        return druidDataSource;
    }

    /**
     * 配置 druid的监控页功能
     *
     */
//    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        //配置一下登录
        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","123");

        return registrationBean;
    }

    /**
     * WebStatFilter 用于采集web-jdbc关联监控的数据
     */
//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//
//        return null;
//    }

}
