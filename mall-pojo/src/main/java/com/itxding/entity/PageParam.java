package com.itxding.entity;

import lombok.Data;

import java.io.Serializable;

@Data
/**
 * 分页通用请求参数
 */
public class PageParam implements Serializable {
    // 当前页码
    private Integer pageNum = 1;
    // 每页条数
    private Integer pageSize = 10;
    // 搜索关键词（用户名/姓名）
    private String keyword;
}
