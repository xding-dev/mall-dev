package com.itxding.service;

import com.itxding.entity.PmsProductCategoryExt;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 查询所有一级分类及子分类
     * @return
     */
    List<PmsProductCategoryExt> getProductCategoryListWithChildren();
}
