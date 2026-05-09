package com.itxding.service.impl;

import com.itxding.entity.UmsAdmin;
import com.itxding.mapper.RoleMapper;
import com.itxding.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    /**
     * 获取所有角色信息
     * @return
     */
    public List<UmsAdmin> getAllRoles() {

        return roleMapper.getAllRoles();
    }
}
