package com.itxding.controller;

import com.itxding.entity.UmsAdmin;
import com.itxding.result.Result;
import com.itxding.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
/**
 * 角色接口
 */
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取所有角色信息
     * @return
     */
    @GetMapping("/listAll")
    public Result<List<UmsAdmin>> getAllRoles(){

        return Result.success(roleService.getAllRoles());
    }
}
