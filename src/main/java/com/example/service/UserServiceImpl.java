package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author wangwei
 * @date 2019/9/22 19:42
 */
@CacheConfig(cacheNames = "myCache") //统一配置本类的缓存注解的属性
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(key = "#id")  //要针对方法配置,能够根据方法的请求参数对其进行缓存
    public User getUserById(Integer id) {
        System.out.println("查询"+id+"号员工信息");
        return userMapper.getUserById(id);
    }

    @Override
    @CachePut(key = "#user.id")
    public User updateUser(User user) {
        System.out.println("更新"+user.getId()+"号员工信息");
        userMapper.updateUser(user);
        return user;
    }
}
