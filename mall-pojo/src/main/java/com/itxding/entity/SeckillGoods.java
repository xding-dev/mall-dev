package com.itxding.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 秒杀商品表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeckillGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    //关联的商品ID
    private Long goodsId;

    //秒杀价格
    private BigDecimal seckillPrice;

    //秒杀库存
     private Integer stockCount;

    //秒杀开始时间
    private LocalDateTime startDate;

    //秒杀结束时间
    private LocalDateTime endDate;
}
