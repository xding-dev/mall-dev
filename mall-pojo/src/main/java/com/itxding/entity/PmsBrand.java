package com.itxding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 商品品牌表
 */
@Data
@TableName("pms_brand")
public class PmsBrand {
    // 主键ID
    @TableId(type = IdType.AUTO)
    private Long id;

    // 品牌名称
    private String name;

    // 品牌首字母
    private String firstLetter;

    // 排序
    private Integer sort;

    // 品牌制造商
    private String manufacturer;

    // 是否显示：0=不显示，1=显示
    private Integer showStatus;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;
}