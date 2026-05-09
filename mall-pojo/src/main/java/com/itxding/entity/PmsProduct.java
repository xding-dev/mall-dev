package com.itxding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商品主表
 */
@Data
@TableName("pms_product")
public class PmsProduct {
    // 主键ID
    @TableId(type = IdType.AUTO)
    private Long id;

    // 商品名称
    private String name;

    // 商品货号（唯一）
    private String sn;

    // 商品分类ID
    private Long categoryId;

    // 品牌ID
    private Long brandId;

    // 商品类型ID
    private Long productTypeId;

    // 商品价格
    private BigDecimal price;

    // 总库存
    private Integer stock;

    // 销量
    private Integer sale;

    // 商品主图
    private String pic;

    // 上架状态：0=下架，1=上架
    private Integer status;

    // 审核状态：0=待审核，1=通过，2=不通过
    private Integer verifyStatus;

    // 排序
    private Integer sort;

    // 商品详情
    private String detail;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;
}