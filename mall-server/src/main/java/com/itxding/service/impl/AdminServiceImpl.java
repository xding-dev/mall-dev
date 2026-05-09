package com.itxding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itxding.entity.PageParam;
import com.itxding.entity.UmsAdmin;
import com.itxding.mapper.UmsAdminMapper;
import com.itxding.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UmsAdminMapper adminMapper;
    /**
     *  分页获取用户列表（完全匹配前端接口）
     *
     * @param pageParam
     * @return
     */
    public IPage<UmsAdmin> getAdminList(PageParam pageParam) {
        // 1. 构建分页对象
        Page<UmsAdmin> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());

        // 2. 构建查询条件（模糊搜索：用户名/昵称）
        LambdaQueryWrapper<UmsAdmin> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasText(pageParam.getKeyword()), UmsAdmin::getUsername, pageParam.getKeyword())
                .or()
                .like(StringUtils.hasText(pageParam.getKeyword()), UmsAdmin::getNickname, pageParam.getKeyword());

        // 3. 分页查询
        IPage<UmsAdmin> adminPage = adminMapper.selectPage(page, wrapper);

        // 4. 隐藏密码（核心！禁止返回密码）
        adminPage.getRecords().forEach(admin -> admin.setPassword(null));

        return adminPage;
    }

}
