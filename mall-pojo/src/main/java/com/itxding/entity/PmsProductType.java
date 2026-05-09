package com.itxding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 商品类型表
 */
@Data
@TableName("pms_product_type")
public class PmsProductType {
    // 主键ID
    @TableId(type = IdType.AUTO)
    private Long id;

    // 类型名称（手机/服装等）
    private String name;

    // 关联属性数量
    private Integer attributeCount;

    // 关联参数数量
    private Integer paramCount;

    // 排序
    private Integer sort;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;
}