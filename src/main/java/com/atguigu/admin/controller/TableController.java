package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){

        userService.removeById(id);

        ra.addAttribute("pn","pn");
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Model model){

        //表格内容的遍历
//        List<User> users = Arrays.asList(new User("estela", "666"),
//                new User("bob", "999"),
//                new User("yst", "0106"));
//        model.addAttribute("users",users);
        return "table/dynamic_table";
    }

    //上面的平替
    @GetMapping("/dynamic_tables")
    public String dynamic_tables(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){

        //从数据库中查出user表中的用户进行展示
        List<User> list = userService.list();

//        model.addAttribute("users",list);

        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);

        //分页查询的结果
        Page<User> page = userService.page(userPage, null);
        long current = page.getCurrent(); //当前页
        long pages = page.getPages(); //总页数
        long total = page.getTotal(); //总记录数
        List<User> records = page.getRecords();

        model.addAttribute("page",page);

        return "table/dynamic_tables";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table(){

        return "pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }



}
