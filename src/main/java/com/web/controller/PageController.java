package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
    
    @RequestMapping("index")
    public String toIndex() {
        return "index";
    }
    @RequestMapping("register")
    public String toRegister() {
        return "register";
    }
    @RequestMapping("registersuccess")
    public String toRegisterSuccess() {
        return "registersuccess";
    }
    @RequestMapping("test")
    public String toTest() {
        return "test";
    }
    @RequestMapping("activesuccess")
    public String toActiveSuccess() {
        return "activesuccess";
    }
    @RequestMapping("login")
    public String toLogin() {
        return "login";
    }
}
