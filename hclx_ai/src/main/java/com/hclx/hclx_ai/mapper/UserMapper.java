package com.hclx.hclx_ai.mapper;

import com.hclx.hclx_ai.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author springBoot-Learning
 * @since 2024-12-10
 */
public interface UserMapper extends BaseMapper<User> {

    int insertUser(User user);

    User selectUserByUsername(String username);
}
