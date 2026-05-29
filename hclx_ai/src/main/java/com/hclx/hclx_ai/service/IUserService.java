package com.hclx.hclx_ai.service;

import com.hclx.hclx_ai.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author springBoot-Learning
 * @since 2024-12-10
 */
public interface IUserService extends IService<User> {
    /**
     * 添加用户的方法
     * @param user
     * @return
     */
    public boolean addUser(User user);

    /**
     * 登录验证的方法
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password);

}
