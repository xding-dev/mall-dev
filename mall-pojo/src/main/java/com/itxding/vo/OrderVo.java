package com.itxding.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long orderId;
    private String goodsName;
    private String goodsImg;
    private BigDecimal goodsPrice;
    private Integer goodsCount;
    private BigDecimal orderPrice; // 订单总价
    private Integer status;
    private LocalDateTime createDate;
}
