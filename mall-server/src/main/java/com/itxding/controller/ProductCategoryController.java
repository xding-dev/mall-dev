package com.itxding.controller;

import com.itxding.entity.PageParam;
import com.itxding.entity.PmsCategory;
import com.itxding.entity.PmsProductCategoryExt;
import com.itxding.result.CommonPage;
import com.itxding.result.Result;
import com.itxding.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productCategory")
@Slf4j
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 查询所有一级分类及子分类
     * @return
     */
    @GetMapping("/list/withChildren")
    public Result<List<PmsProductCategoryExt>> getProductCategoryListWithChildren() {

        return Result.success(productCategoryService.getProductCategoryListWithChildren());
    }

    /**
     * 分页查询商品分类
     * @param parentId
     * @param pageParam
     * @return
     */
    @GetMapping("/list/{parentId}")
    public Result<CommonPage<PmsCategory>> getProductCategoryList(@PathVariable Long parentId,
                                                                  PageParam pageParam) {

        log.info("分页查询商品分类{},{}",parentId,pageParam);
        CommonPage<PmsCategory> commonPage = productCategoryService.getProductCategoryList(parentId,pageParam);
        return Result.success(commonPage);

    }
}
