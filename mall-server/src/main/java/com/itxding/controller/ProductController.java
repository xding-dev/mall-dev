package com.itxding.controller;

import com.itxding.dto.ProductQueryDto;
import com.itxding.entity.PmsProduct;
import com.itxding.result.CommonPage;
import com.itxding.result.Result;
import com.itxding.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 分页查询商品列表
     * @param productQueryDto
     * @return
     */
    @GetMapping("/list")
    public Result<CommonPage<PmsProduct>> getProductList(ProductQueryDto productQueryDto){
        log.info("查询商品信息：{}",productQueryDto);
        return Result.success(productService.getProductList(productQueryDto));
    }
}
