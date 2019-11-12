package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangwei
 * @date 2019/9/22 19:42
 */
//@CacheConfig(cacheNames = "myCache") //统一配置本类的缓存注解的属性
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired(required=true)
    private RedisUtil redisUtil;

    @Override
    //@Cacheable(key = "#id")  //要针对方法配置,能够根据方法的请求参数对其进行缓存
    public User getUserById(Integer id) {
        User user = (User)redisUtil.get(String.valueOf(id));
        if(user == null){
            System.out.println("查询"+id+"号员工信息");
            user = userMapper.getUserById(id);
            redisUtil.set(String.valueOf(id),user);
        }
        return user;
    }

    @Override
    //@CachePut(key = "#user.id")
    public User updateUser(User user) {
        System.out.println("更新"+user.getId()+"号员工信息");
        userMapper.updateUser(user);
        return user;
    }
}
