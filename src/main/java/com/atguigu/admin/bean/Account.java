package com.atguigu.admin.bean;

import lombok.Data;

@Data
public class Account {

    private Long id; //因为int长度是11，所以这里的类型是long类型
    private String userId;
    private Integer money;
}
