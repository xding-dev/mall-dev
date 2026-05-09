package com.itxding.service;

import com.itxding.dto.User;
import com.itxding.entity.LoginDto;

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
