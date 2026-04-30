package com.itxding.entity;


import lombok.Data;
import java.io.Serializable;

@Data
public class LoginDto implements Serializable {

    private static final long serialVersionUID = 1L;

    //用户名
    private String username;

    // 密码
    private String password;
}
