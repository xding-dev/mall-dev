package com.itxding.dto;

import lombok.Data;

/**
 * 商品批量上下架参数
 *
 */
@Data
public class ProductPublishStatusParamDTO {
    /**
     * 商品ID列表（逗号分隔的字符串，如 "1,2,3"）
     */
    private String ids;

    /**
     * 商品上架状态：0=下架，1=上架
     */
    private Integer publishStatus;
}