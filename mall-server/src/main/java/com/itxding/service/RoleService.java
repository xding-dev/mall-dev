package com.itxding.service;

import com.itxding.entity.UmsAdmin;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {
    /**
     * 获取所有角色信息
     * @return
     */
    List<UmsAdmin> getAllRoles();
}
