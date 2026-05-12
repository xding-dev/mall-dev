package com.itxding.service;

import com.itxding.dto.ProductNewStatusDTO;
import com.itxding.dto.ProductPublishStatusDTO;
import com.itxding.dto.ProductQueryDto;
import com.itxding.dto.ProductRecommendStatusDTO;
import com.itxding.entity.PmsProduct;
import com.itxding.result.CommonPage;

public interface ProductService {

    /**
     *分页查询商品列表
     * @param productQueryDto
     * @return
     */
    CommonPage<PmsProduct> getProductList(ProductQueryDto productQueryDto);

    /**
     * 批量上下架商品
     * @param paramDTO
     */
    void productUpdatePublishStatus(ProductPublishStatusDTO paramDTO);


    /**
     * 批量推荐商品
     * @param paramDTO
     */
    void productUpdateRecommend(ProductRecommendStatusDTO paramDTO);

    /**
     * 批量设为新品
     * @param paramDTO
     */
    void productUpdateNew(ProductNewStatusDTO paramDTO);
}
