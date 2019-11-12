package com.example.controller;

import com.example.entity.User;
import com.example.service.IUserService;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangwei
 * @date 2019/9/22 12:48
 */

@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/getUser")
    public String getUser(int id) {
        User user = (User)redisUtil.get(String.valueOf(id));
        if(user == null){
            System.out.println("查询员工数据");
            user = userService.getUserById(id);
            redisUtil.set(String.valueOf(id),user);
        }
        return user.toString();
    }

    @RequestMapping("/updateUser")
    public void updateUser(User user){

        System.out.println("更新员工数据");
        userService.updateUser(user);
    }
}