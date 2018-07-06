package com.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value="register",method=RequestMethod.POST)
    public String register() {
        
        return null;
    }
    @RequestMapping(value="login",method=RequestMethod.POST)
    public String login() {
        
        return null;
    }
    @RequestMapping(value="logout",method=RequestMethod.POST)
    public String logout() {
        
        return null;
    }
    
}
