package com.itxding.dto;

import lombok.Data;

/**
 * 商品批量推荐
 *
 */
@Data
public class ProductRecommendStatusDTO {
    /**
     * 商品ID列表（逗号分隔的字符串，如 "1,2,3"）
     */
    private String ids;

    /**
     * 商品推荐状态：0=下架，1=上架
     */
    private Integer recommendStatus;
}