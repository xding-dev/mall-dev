package com.itxding.controller;

import com.itxding.entity.PmsProductCategoryExt;
import com.itxding.result.Result;
import com.itxding.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
