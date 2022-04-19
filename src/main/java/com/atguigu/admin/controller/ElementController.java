package com.atguigu.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ElementController {

    @GetMapping("/button")
    public String button(){

        return "elements/buttons";
    }
}
