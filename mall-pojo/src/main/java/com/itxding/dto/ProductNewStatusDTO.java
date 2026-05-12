package com.itxding.dto;

import lombok.Data;

/**
 * 商品批量上下架参数
 *
 */
@Data
public class ProductNewStatusDTO {
    /**
     * 商品ID列表（逗号分隔的字符串，如 "1,2,3"）
     */
    private String ids;

    /**
     * 新品状态：0-不是新品，1-是新品
     */
    private Integer newStatus;
}