package com.itxding.dto;

import com.itxding.entity.PageParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductQueryDto extends PageParam implements Serializable {
    /**
     * 商品上架状态
     * 0-下架，1-上架（对应前端publishStatus）
     */
    private Integer publishStatus;

    /**
     * 商品审核状态
     * 0-待审核，1-审核通过，2-审核不通过（对应前端verifyStatus）
     */
    private Integer verifyStatus;

    /**
     * 商品货号（模糊查询，对应前端productSn）
     */
    private String productSn;

    /**
     * 商品分类ID（对应前端productCategoryId）
     */
    private Long productCategoryId;

    /**
     * 商品品牌ID（对应前端brandId）
     */
    private Long brandId;
}
