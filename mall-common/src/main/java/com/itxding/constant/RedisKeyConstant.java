package com.itxding.constant;

// Redis Key 常量类 统一管理 Redis 的 Key，避免硬编码，方便维护。
public class RedisKeyConstant {

    /**
     * 秒杀商品库存 Key 前缀
     */
    public static final String SECKILL_GOODS_STOCK_PREFIX = "seckill:goods:stock:";

    /**
     * 秒杀订单 Key 前缀（防止重复秒杀）
     */
    public static final String SECKILL_ORDER_PREFIX = "seckill:order:";

    /**
     * 分布式锁 Key 前缀
     */
    public static final String SECKILL_LOCK_PREFIX = "seckill:lock:";

    /**
     * 商品详情 Key 前缀
     */
    public static final String GOODS_DETAIL_PREFIX = "goods:detail:";
}
