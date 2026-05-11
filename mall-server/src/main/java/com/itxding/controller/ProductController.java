package com.itxding.controller;

import com.itxding.dto.ProductPublishStatusParamDTO;
import com.itxding.dto.ProductQueryDto;
import com.itxding.entity.PmsProduct;
import com.itxding.result.CommonPage;
import com.itxding.result.Result;
import com.itxding.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 批量上下架商品
     * @param paramDTO
     * @return
     */
    @PostMapping("/update/publishStatus")
    public Result productUpdatePublishStatus(@RequestBody ProductPublishStatusParamDTO paramDTO){
        log.info("批量上下架商品：{}",paramDTO);
        productService.productUpdatePublishStatus(paramDTO);
        return Result.success();
    }
}
