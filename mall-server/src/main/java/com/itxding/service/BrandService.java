package com.itxding.service;

import com.itxding.entity.PageParam;
import com.itxding.entity.PmsBrand;
import com.itxding.result.CommonPage;

public interface BrandService {
    /**
     * 根据品牌名称分页获取品牌列表
     * @param pageParam
     * @return
     */
    CommonPage<PmsBrand> getBrandList(PageParam pageParam);
}
