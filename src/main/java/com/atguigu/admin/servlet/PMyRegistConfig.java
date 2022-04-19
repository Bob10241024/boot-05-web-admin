package com.atguigu.admin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * (proxyBeanMethods = false): 保证依赖的组件始终是单实例的
 */
@Configuration(proxyBeanMethods = true)
public class PMyRegistConfig {

    @Bean
    public ServletRegistrationBean PMyServlet(){
        PMyServlet pMyServlet = new PMyServlet();

        return new ServletRegistrationBean(pMyServlet,"/my","/my02");
    }

    @Bean
    public FilterRegistrationBean PMyFilter(){
        PMyFilter pMyFilter = new PMyFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(pMyFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));

//        return new FilterRegistrationBean(pMyFilter,PMyServlet());
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(myServletContextListener);
    }
}
