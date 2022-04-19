package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;


@Mapper //告诉mybatis这是mapper接口。
public interface AccountMapper {

    //接口是没有方法体的！！！！别写那个大破括号
    public  Account getAcct(Long id);
}
