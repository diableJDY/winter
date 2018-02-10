package com.common.winter.controller;

import com.common.winter.service.UserService;
import com.common.winter.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    /*@Autowired
    UserMapper userMapper;*/

    @RequestMapping("/")
    public String index(HttpSession session){
        //System.out.println("이쪽으로 오너라~");
        User user = userService.readUser("user1");

        session.setAttribute("loginUser",user);

        System.out.println(user.getAuthorities());
        System.out.println(user.toString());


        return "hi";
    }

    @RequestMapping(value = "/user")
    public String user(){
        System.out.println("user ");
        return "hi";
    }

    @RequestMapping(value = "/admin")
    public String admin(){
        System.out.println("admin ");
        return "hi";
    }

    @RequestMapping(value = "/jdy/admin")
    public String jdy(){
        System.out.println("jdy ");
        return "hi";
    }



}
