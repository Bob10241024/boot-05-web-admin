package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_tbl") //指定表名
public class User {

    /**
     * 所有的属性都应该在数据库中
     * 解决办法：
     *      @TableField(exist = false):表明我的这个属性在数据库中不存在
     */
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;


    //以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
