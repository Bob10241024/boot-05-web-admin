package com.atguigu.admin.bean;

import lombok.Data;

/**
 * 最佳实战：
 *  1、引入mybatis-spring-boot-starter
 *  2、配置application.yaml中，指定mapper-location位置即可
 *  3、编写Mapper接口并标注@Mapper注解
 *  4、简单方法直接注解方式
 *  5、复杂方法编写mapper.xml进行绑定映射
 *  6、@MapperScan("com.atguigu.admin.mapper")简化，其他的接口就可以不用标注@Mapper注解
 */

@Data
public class City {

    private Long id;
    private String name;
    private String state;
    private String country;
}
