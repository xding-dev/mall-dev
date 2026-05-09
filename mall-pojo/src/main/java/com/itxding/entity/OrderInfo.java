package com.itxding.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    // 用户ID
    private Long userId;

    //商品ID
    private Long goodsId;

    //收货地址ID
    private Long deliveryAddrId;

    // 商品名称（冗余字段，方便查询）
    private String goodsName;

    // 商品数量
    private Integer goodsCount;

    //商品单价
    private BigDecimal goodsPrice;

    // 订单渠道：1-pc，2-android，3-ios
    private Integer orderChannel;

    //订单状态：0-新建未支付，1-已支付，2-已发货，3-已收货，4-已退款，5-已完成
    private Integer status;

    //订单创建时间
    private LocalDateTime createDate;

    //支付时间
    private LocalDateTime payDate;
}
