package com.itxding.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    //商品名称
    private String goodsName;

    //商品标题
    private String goodsTitle;

    //商品图片
    private String goodsImg;

    // 商品详情
    private String goodsDetail;

    //商品价格
    private BigDecimal goodsPrice;

    // 商品库存
    private Integer goodsStock;

}
