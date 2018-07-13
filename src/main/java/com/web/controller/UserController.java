package com.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
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

    @RequestMapping(value = "checkEmail", method = RequestMethod.GET)
    public void checkEmail(String email, PrintWriter writer) {
        // 调用业务层进行邮箱校验
        /*
         * if(!"".equals(email) && email != null) { writer.write("true"); }else
         * { writer.write("false"); }
         */
        try {
            User user = userService.findUserByEmail(email);
            System.out.println(user);
            if (user != null)
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

    @RequestMapping(value = "checkUsername", method = RequestMethod.GET)
    public void checkUsername(String username, PrintWriter writer) {
        // 调用业务层进行用户名校验
        /*
         * if(!"".equals(username) || username != null) { writer.write("true");
         * }else { writer.write("false"); }
         */
        try {
            User user = userService.findUserByUsername(username);
            if (user != null)
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

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user, HttpServletRequest request) {
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
    public String activeUser(String activeCode, PrintWriter writer, HttpServletResponse response) {
        if (activeCode != null && !"".equals(activeCode)) {
            try {
                userService.activerUser(activeCode);
            } catch (UserException e) {
                writer.write(e.getMessage());
                writer.flush();
                writer.close();
            }
        } else { // 无法识别的请求

        }
        /*
         * response.setContentType("text/html;charset=utf-8");
         * response.setCharacterEncoding("UTF-8");
         */
        return "redirect:/page/activesuccess.do";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if("".equals(user.getUsername()) || user.getUsername() == null || "".equals(user.getPassword()) || user.getPassword() == null) {
            request.setAttribute("errorMsg", "用户名和密码不能为空！");
            return "forward:/page/login.do";
        }
        try {
            // 是否记住用户名
            String isRememberUsername = request.getParameter("isRememberUsername");
            createCookie(response, Integer.MAX_VALUE, "rememberUserName", user.getUsername(),
                    isRememberUsername != null);
            createCookie(response, Integer.MAX_VALUE, "userNameCheck", "checked",
                    isRememberUsername != null);
            createCookie(response, Integer.MAX_VALUE, "rememberPassword", user.getPassword(),
                    isRememberUsername != null);
            User loginUser = userService.login(user);
            
            if (loginUser != null) {
                if (loginUser.getState() == 1) {
                    HttpSession session = request.getSession();
                    session.setAttribute("loginUser", loginUser);
                    // 是否自动登录
                    String isAutoLogin = request.getParameter("isAutoLogin");
                    createCookie(response, 60 * 60 * 24 * 7, "autoLogin", user.getUsername() + "&" + user.getPassword(),
                            isAutoLogin != null);
                    createCookie(response, 60 * 60 * 24 * 7, "autoLoginCheck", "checked",
                            isAutoLogin != null);
                    session.setAttribute("loginStatus", true);
                    if (!"管理员".equals(loginUser.getRole())) {
                        // 普通用户
                        /*String url = (String) request.getSession().getAttribute("url");
                        if (url != null) {
                            // 跳转到指定页面
                            request.getSession().removeAttribute("url");
                            writer.write(url);
                        } else {
                            // 跳转到首页
                            writer.write("/page/index.do");
                        }*/
                        return "redirect:/page/index.do";
                    } else {
                        // 管理员登录
                        // writer.write("");
                        return "redirect:/page/index.do";
                    }
                    
                }else {
                    //用户未激活
                    //writer.write("该用户还没有激活，请先去激活!");
                    request.setAttribute("errorMsg", "该用户还没有激活，请先去激活!");
                    return "forward:/page/login.do";
                }
            }else {
                //登录失败
                //writer.write("false");
                request.setAttribute("errorMsg", "用户名或密码错误！");
                return "forward:/page/login.do";
            }
        } catch (UserException e) {
            request.setAttribute("errorMsg", "服务器繁忙！");
            return "forward:/page/login.do";
        }
        
    }
    @RequestMapping(value="userInfo",method=RequestMethod.GET)
    public String getUserInfo(HttpServletRequest request,
            HttpServletResponse response) {
        User user = (User)request.getSession().getAttribute("loginUser");
        //判断是否已经登录
        if(user == null) {//未登录
            return "redirect:/page/login.do";
        }else
            return "forward:/page/myAccount.do";
            
    }
    
    @RequestMapping(value="modifyUserInfo")
    public String modifyUserInfo(User user,HttpServletRequest request,HttpServletResponse response) {
        try {
            userService.modifyUserInfo(user);
            User loginUser = (User) request.getSession().getAttribute("loginUser");
            if(loginUser != null) {
                request.getSession().removeAttribute("loginUser");
                request.getSession().setAttribute("loginStatus", false);
                //删除自动登录的cookie
                Cookie[] cookies = request.getCookies();
                for(Cookie cookie : cookies) {
                    if("autoLogin".equals(cookie.getName())) {
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                        break;
                    }
                }
            }
            return "forward:/page/modifyUserInfoSuccess.do";
        } catch (UserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("index")
    public String toIndex(ModelMap modelMap, HttpServletRequest request) {
        return "index";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if(loginUser != null) {
            request.getSession().removeAttribute("loginUser");
            request.getSession().setAttribute("loginStatus", "false");
            //request.getSession().removeAttribute("loginStatus");
            //删除自动登录的cookie
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie : cookies) {
                if("autoLogin".equals(cookie.getName())) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        return "redirect:/page/login.do";
    }

    private void createCookie(HttpServletResponse response, int time, String name, String value, boolean condition) {
        Cookie cookie = new Cookie(name, value);
        
        cookie.setPath("/");
        if (condition) {
            cookie.setMaxAge(time);
        } else {
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);
    }

}
