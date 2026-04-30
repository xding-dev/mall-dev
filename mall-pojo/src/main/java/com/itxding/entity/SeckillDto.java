package com.itxding.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SeckillDto implements Serializable {

    private static final long serialVersionUID = 1L;

    // 要秒杀的商品ID
    private Long goodsId;

}
