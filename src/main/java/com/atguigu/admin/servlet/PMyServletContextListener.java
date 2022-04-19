package com.atguigu.admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web原生组件注入（Servlet、Filter、Listener）
 * 使用Servlet API
 */
@Slf4j
@WebListener
public class PMyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("PMyServletContextListener监听到项目初始化完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("PMyServletContextListener监听到项目销毁");
    }
}
