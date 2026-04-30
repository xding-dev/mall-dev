package com.itxding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 秒杀订单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeckillOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    // 用户ID
    private Long userId;

    // 订单ID
    private Long orderId;

    //商品ID
    private Long goodsId;

}
