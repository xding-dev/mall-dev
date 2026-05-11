package com.itxding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itxding.entity.PageParam;
import com.itxding.entity.PmsBrand;
import com.itxding.mapper.BrandMapper;
import com.itxding.result.CommonPage;
import com.itxding.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;
    /**
     * 根据品牌名称分页获取品牌列表
     * @param pageParam
     * @return
     */
    public CommonPage<PmsBrand> getBrandList(PageParam pageParam) {
        //1.构建分页对象
        Page<PmsBrand> page = new Page<>(pageParam.getPageNum(),pageParam.getPageSize());

        // 2. 构建动态查询条件
        LambdaQueryWrapper<PmsBrand> wrapper = new LambdaQueryWrapper<>();
        // 模糊搜索品牌名称，keyword为空时不拼接条件
        wrapper.like(StringUtils.hasText(pageParam.getKeyword()), PmsBrand::getName, pageParam.getKeyword())
                // 按排序字段升序排列，符合品牌管理的排序需求
                .orderByAsc(PmsBrand::getSort);

        // 3. 分页查询
        IPage<PmsBrand> brandPage = brandMapper.selectPage(page, wrapper);

        // 4. 转换为通用分页结果
        return CommonPage.restPage(brandPage);



    }
}
