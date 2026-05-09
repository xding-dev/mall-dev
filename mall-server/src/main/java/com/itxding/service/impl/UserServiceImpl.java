package com.itxding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itxding.dto.User;
import com.itxding.entity.LoginDto;
import com.itxding.exceltion.BusinessException;
import com.itxding.mapper.UserMapper;
import com.itxding.service.UserService;
import com.itxding.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录接口：前端唯一对接的登录入口
     *
     * @param loginDto
     * @return
     */
    public String login(LoginDto loginDto) {
        //1.参数非空检验
        if (loginDto.getUsername() == null || loginDto.getPassword() == null) {
            throw new BusinessException("用户名/密码不能为空");
        }

        // 2. 根据用户名查询数据库
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, loginDto.getUsername());
        User user = userMapper.selectOne(wrapper);

        // 3. 用户不存在
        if (user == null) {
            throw new BusinessException("用户不存在");
        }
        // 4. 密码校验
        if (!user.getPassword().equals(loginDto.getPassword())) {
            throw new BusinessException("密码错误");
        }

        // 5. 生成JWT Token（返回给前端）
        return JwtUtil.generateToken(user.getId(), user.getUsername());
    }

    /**
     *
     * 获得当前用户登录信息
     * @param userId
     * @return
     */
    public User getById(Long userId) {

        return  userMapper.selectById(userId);
    }
}
