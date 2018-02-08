package com.common.winter.controller;

import com.common.winter.mapper.UserMapper;
import com.common.winter.service.UserService;
import com.common.winter.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    /*@Autowired
    UserMapper userMapper;*/

    @RequestMapping("/")
    public String index(){
        //System.out.println("이쪽으로 오너라~");
        User user = userService.readUser("user1");

        System.out.println(user.getAuthorities());
        System.out.println(user.toString());


        return "hi";
    }




}
