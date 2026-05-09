package com.itxding.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UmsRole {
    private Long id;
    private String name; // 角色名称（如"超级管理员"）
    private String description; // 角色描述
    private Integer status; // 状态 0-禁用 1-启用
    private LocalDateTime createTime; // 创建时间
}
