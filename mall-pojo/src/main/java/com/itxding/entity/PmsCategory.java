package com.itxding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 商品分类表
 */
@Data
@TableName("pms_category")
public class PmsCategory {
    // 主键ID
    @TableId(type = IdType.AUTO)
    private Long id;

    // 分类名称
    private String name;

    // 上级分类ID，0=顶级分类
    private Long parentId;

    // 数量单位
    private String unit;

    // 排序
    private Integer sort;

    // 是否显示：0=不显示，1=显示
    private Integer showStatus;

    // 是否显示在导航栏：0=不显示，1=显示
    private Integer navStatus;

    // 分类图标路径
    private String icon;

    // 搜索关键词
    private String keywords;

    // 分类描述
    private String description;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;
}