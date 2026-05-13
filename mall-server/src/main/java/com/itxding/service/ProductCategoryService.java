package com.itxding.service;

import com.itxding.entity.PageParam;
import com.itxding.entity.PmsCategory;
import com.itxding.entity.PmsProductCategoryExt;
import com.itxding.result.CommonPage;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 查询所有一级分类及子分类
     * @return
     */
    List<PmsProductCategoryExt> getProductCategoryListWithChildren();

    /**
     * 分页查询商品分类
     * @param parentId
     * @param pageParam
     * @return
     */
    CommonPage<PmsCategory> getProductCategoryList(Long parentId, PageParam pageParam);
}
