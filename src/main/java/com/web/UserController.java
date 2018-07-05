package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    //@RequestMapping("hello")
    //@RequestMapping(value="hello")
    //@RequestMapping(value="/hello.do")
    //@RequestMapping(value="/hello.do",method=RequestMethod.GET)
//    @RequestMapping(value="/hello.do",method=RequestMethod.POST)
    @RequestMapping(value="/hello.do",method= {RequestMethod.GET,RequestMethod.POST})
    //@RequestMapping("/hello.do")
    public String hello() {
        return "index";
    }
}
