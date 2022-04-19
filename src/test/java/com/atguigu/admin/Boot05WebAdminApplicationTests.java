package com.atguigu.admin;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class  Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    /**
     * 测试数据库场景配置
     */
    @Test
    void contextLoads() {

//        jdbcTemplate.queryForObject("select * from books");
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from books");
        Long aLong = jdbcTemplate.queryForObject("select count(*) from books", Long.class);
        log.info("记录总数:{}",aLong);

        log.info("数据源类型: {}",dataSource.getClass());
    }

    /**
     * 测试UserMapper（Mybatis-Plus）
     *
     */
    @Test
    void testUserMapper(){

        User user = userMapper.selectById(1L);
        log.info("用户信息:{}",user);
    }


}
