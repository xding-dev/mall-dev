package com.itxding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    //主键 用户id
    private Long id;

    //用户名
    private String username;

    //密码（加密存储）
    private String password;

    //创建时间
    private LocalDateTime createTime;
}
