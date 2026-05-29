package com.hclx.hclx_ai.service.impl;

import com.hclx.hclx_ai.entity.User;
import com.hclx.hclx_ai.mapper.UserMapper;
import com.hclx.hclx_ai.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author springBoot-Learning
 * @since 2024-12-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        int i = userMapper.insertUser(user);
        return i > 0;
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.selectUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
