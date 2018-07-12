package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
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
        return "register3";
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
    @RequestMapping("myAccount")
    public String toMyAccount() {
        return "myAccount";
    }
    @RequestMapping("modifyUserInfo")
    public String modifyUserInfo() {
        return "modifyuserinfo";
    }
    @RequestMapping("modifyUserInfoSuccess")
    public String modifyUserInfoSuccess() {
        return "modifyUserInfoSuccess";
    }
    @RequestMapping("product_list")
    public String toProduct_list() {
        return "product_list";
    }
    @RequestMapping("product_info")
    public String toProduct_info() {
        return "product_info";
    }
    @RequestMapping("cart")
    public String toCart() {
        return "cart";
    }
    @RequestMapping("order")
    public String toOrder() {
        return "order";
    }
    @RequestMapping("pay")
    public String toPay() {
        return "pay";
    }
    @RequestMapping("orderList")
    public String toOrderList() {
        return "orderlist";
    }
    @RequestMapping("orderInfo")
    public String toOrderInfo() {
        return "orderInfo";
    }
    
}
