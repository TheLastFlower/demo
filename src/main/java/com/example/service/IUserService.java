package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author wangwei
 * @date 2019/9/22 19:40
 */

public interface IUserService {

    User getUserById(Integer id);

    User updateUser(User user);
}
