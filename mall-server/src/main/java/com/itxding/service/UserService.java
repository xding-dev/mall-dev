package com.itxding.service;

import com.itxding.entity.User;
import com.itxding.dto.LoginDto;

public interface UserService {
    /**
     * 登录接口：前端唯一对接的登录入口
     * @param loginDto
     * @return
     */
    String login(LoginDto loginDto);

    /**
     *
     * 获得当前用户登录信息
     * @param userId
     * @return
     */
    User getById(Long userId);
}
