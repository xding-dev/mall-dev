package com.itxding.entity;

import lombok.Data;

import java.util.List;

/**
 * 商品分类扩展类（带子分类）
 * 对应前端 PmsProductCategoryExt 类型
 */
@Data
public class PmsProductCategoryExt extends PmsCategory{
    //子分类列表
    private List<PmsProductCategoryExt> children;

}
