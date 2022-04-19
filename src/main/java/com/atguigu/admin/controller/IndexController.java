package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.impl.AccountServiceImpl;
import com.atguigu.admin.service.impl.CityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    /**
     * 测试监控页
     */

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountServiceImpl accountService;

    @Autowired
    CityServiceImpl cityService;

    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){

        cityService.saveCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }

    @ResponseBody //转成json
    @GetMapping("/acct") //跳转界面
    public Account getById(@RequestParam("id") Long id){

        return accountService.getAcctByid(id);
    }


    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from books", Long.class);
        return aLong.toString();
    }


    /**
     * 来登录页
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }

    /**
     * 输入账户密码，进入真正的页面
     */
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if (StringUtils.hasLength(user.getUserName()) && "123".equals(user.getPassword())){
            //把登录成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","账号密码错误");
            //返回到登录界面
            return "login";
        }


    }

    /**
     * 去main页面
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){

        log.info("当前方法是:{}","mainPage");
//        //是否登录  拦截器，过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null){
//            return "main";
//        }else{
//            //回到登陆页面
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }

        return "main";

    }
}
