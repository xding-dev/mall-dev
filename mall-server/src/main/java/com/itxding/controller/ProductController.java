package com.itxding.controller;

import com.itxding.dto.*;
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
    public Result productUpdatePublishStatus(@RequestBody ProductPublishStatusDTO paramDTO){
        log.info("批量上下架商品：{}",paramDTO);
        productService.productUpdatePublishStatus(paramDTO);
        return Result.success();
    }

    /**
     * 批量推荐商品
     * @param paramDTO
     * @return
     */
    @PostMapping("/update/recommendStatus")
    public Result productUpdateRecommendStatus(@RequestBody ProductRecommendStatusDTO paramDTO){
        log.info("批量推荐商品：{}",paramDTO);
        productService.productUpdateRecommend(paramDTO);
        return Result.success();
    }

    /**
     * 批量设为新品
     * @param paramDTO
     * @return
     */
    @PostMapping("update/newStatus")
    public Result productUpdateNewStatus( ProductNewStatusDTO paramDTO){
        log.info("批量设为新品：{}",paramDTO);
        productService.productUpdateNew(paramDTO);
        return Result.success();
    }


    /**
     * 批量删除商品
     * @param paramDTO
     * @return
     */
    @PostMapping("/update/deleteStatus")
    public Result<Void> updateDeleteStatus(ProductDeleteStatusParamDTO paramDTO) {
        productService.updateDeleteStatus(paramDTO);
        return Result.success();
    }

}
