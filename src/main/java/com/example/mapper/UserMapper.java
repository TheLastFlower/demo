package com.example.mapper;

import com.example.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author wangwei
 * @date 2019/9/22 19:42
 */
@Repository
public interface UserMapper {

    User getUserById(Integer id);

    void updateUser(User user);
}
