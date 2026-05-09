package com.itxding.controller;

import com.itxding.dto.User;
import com.itxding.entity.LoginDto;
import com.itxding.result.Result;
import com.itxding.service.UserService;
import com.itxding.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录接口：前端唯一对接的登录入口
     * @param loginDto
     * @return
     */
    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginDto loginDto) {
        // 调用业务层，返回token
        String token = userService.login(loginDto);
        return Result.success(token);
    }

    /**
     * 获取当前登录用户信息
     * 前端请求：GET /admin/info
     */
    @GetMapping("/info")
    public Result<User> getAdminInfo(@RequestHeader("Authorization") String tokenHeader) {
        // 1. 从请求头的Token中解析用户ID（注意去掉Bearer前缀）
        String token = tokenHeader.replace("Bearer ", "");
        Long userId = JwtUtil.getUserId(token);

        // 2. 根据用户ID查询用户信息
        User user = userService.getById(userId);
        if (user == null) {
            return Result.error("用户不存在");
        }

        // 3. 关键：隐藏敏感信息（不要把密码返回给前端）
        user.setPassword(null);

        // 4. 返回统一格式结果
        return Result.success(user);
    }

    /**
     * 退出登录接口
     * 前端调用路径：POST /admin/logout
     */
    @PostMapping("/logout")
    public Result logout(@RequestHeader("Authorization") String tokenHeader) {
        // 可选：如果后续要做Redis黑名单，这里可以把Token加入黑名单
        // 目前JWT无状态场景，后端无需额外操作，直接返回成功即可
        return Result.success();
    }
}
