package com.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.domain.User;
import com.exception.UserException;
import com.service.UserService;
import com.service.impl.UserServiceImpl;


@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(value="checkEmail", method=RequestMethod.GET) 
    public void checkEmail(String email,PrintWriter writer) {
        //调用业务层进行邮箱校验
        /*if(!"".equals(email) && email != null) {
            writer.write("true");
        }else {
            writer.write("false");
        }*/
        try {
            User user = userService.findUserByEmail(email);
            System.out.println(user);
            if(user != null)
                writer.write("false");
            else 
                writer.write("true");
        } catch (UserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        writer.flush();
        writer.close();
    }
    @RequestMapping(value="checkUsername",method=RequestMethod.GET)
    public void checkUsername(String username,PrintWriter writer) {
        //调用业务层进行用户名校验
        /*if(!"".equals(username) || username != null) {
            writer.write("true");
        }else {
            writer.write("false");
        }*/
        try {
            User user = userService.findUserByUsername(username);
            if(user != null)
                writer.write("false");
            else
                writer.write("true");
        } catch (UserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        writer.flush();
        writer.close();
    }
    @RequestMapping(value="register",method=RequestMethod.POST)
    public String register(User user,HttpServletRequest request) {
        user.setActivecode(UUID.randomUUID().toString());
        user.setState(0);
        user.setRole("普通用户");
        try {
            userService.register(user);
            return "redirect:/page/registersuccess.do";
        } catch (UserException e) {
            request.setAttribute("registerErrorMsg", e.getMessage());
            return "register";
        }
        
    }
    @RequestMapping("activeUser")
    public String activeUser(String activeCode,PrintWriter writer,HttpServletResponse response) {
        if(activeCode != null && !"".equals(activeCode)) {
            try {
                userService.activerUser(activeCode);
            } catch (UserException e) {
                writer.write(e.getMessage());
                writer.flush();
                writer.close();
            }
        } else { // 无法识别的请求
            
        }
        /*response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");*/
        return "redirect:/page/activesuccess.do";
    }
    @RequestMapping(value="login",method=RequestMethod.POST)
    public String login(User user,HttpSession session) {
        
        return null;
    }
    @RequestMapping("index")
    public String toIndex(ModelMap modelMap,HttpServletRequest request) {
        return "index";
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
