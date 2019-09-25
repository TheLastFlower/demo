package com.example.controller;

import com.example.entity.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangwei
 * @date 2019/9/22 12:48
 */
@EnableCaching  //开启缓存
@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping("/getUser")
    public String getUser(int id) {
        User user = userService.getUserById(id);
        return user.toString();
    }

    @RequestMapping("/updateUser")
    public void updateUser(User user){
        userService.updateUser(user);
    }
}