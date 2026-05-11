package com.itxding.service;

import com.itxding.dto.ProductPublishStatusDTO;
import com.itxding.dto.ProductQueryDto;
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


}
