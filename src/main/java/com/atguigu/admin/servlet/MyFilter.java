package com.atguigu.admin.servlet;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
/**
 * Web原生组件注入（Servlet、Filter、Listener）
 * 使用Servlet API
 */

/**
 *   * : servlet的写法
 *   ** : spring的写法
 */

@Slf4j
//@WebFilter(urlPatterns = "/css/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("MyFilter工作中");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("MyFilter销毁");
    }
}
