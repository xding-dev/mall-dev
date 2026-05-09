package com.itxding.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;

/**
 * 分页通用返回格式
 */
@Data
public class CommonPage<T> {
    // 总记录数
    private Long total;
    // 总页数
    private Long pages;
    // 当前页
    private Integer pageNum;
    // 每页条数
    private Integer pageSize;
    // 数据列表
    private List<T> list;

    /**
     * 将MyBatis-Plus分页结果 转为 通用分页结果
     */
    public static <T> CommonPage<T> restPage(IPage<T> page) {
        CommonPage<T> result = new CommonPage<>();
        result.setTotal(page.getTotal());
        result.setPages(page.getPages());
        result.setPageNum((int) page.getCurrent());
        result.setPageSize((int) page.getSize());
        result.setList(page.getRecords());
        return result;
    }
}
