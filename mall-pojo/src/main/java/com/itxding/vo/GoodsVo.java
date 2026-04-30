package com.itxding.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class GoodsVo implements Serializable {

    private static final long serialVersionUID = 1L;

    // ==================== 普通商品信息 ====================
    private Long id;
    private String goodsName;
    private String goodsTitle;
    private String goodsImg;
    private String goodsDetail;
    private BigDecimal goodsPrice; // 原价
    private Integer goodsStock;

    // ==================== 秒杀商品信息 ====================
    private BigDecimal seckillPrice; // 秒杀价
    private Integer stockCount;      // 秒杀库存
    private LocalDateTime startDate;          // 秒杀开始时间
    private LocalDateTime endDate;            // 秒杀结束时间

    // ==================== 前端展示需要的辅助字段 ====================
    /**
     * 秒杀状态：0-未开始，1-进行中，2-已结束
     */
    private Integer seckillStatus;

    /**
     * 倒计时（秒）
     */
    private Long remainSeconds;
}
