package com.itxding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itxding.dto.ProductQueryDto;
import com.itxding.entity.PmsProduct;
import com.itxding.mapper.ProductMapper;
import com.itxding.result.CommonPage;
import com.itxding.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    /**
     * 分页查询商品列表
     * @param productQueryDto
     * @return
     */
    public CommonPage<PmsProduct> getProductList(ProductQueryDto productQueryDto) {
        //1.构建分页对象
        Page<PmsProduct> page = new Page<>(productQueryDto.getPageNum(), productQueryDto.getPageSize());
        // 2. 构建动态查询条件
        LambdaQueryWrapper<PmsProduct> wrapper = new LambdaQueryWrapper<>();
        // 状态筛选
        wrapper.eq(productQueryDto.getPublishStatus() != null, PmsProduct::getStatus, productQueryDto.getPublishStatus())
                .eq(productQueryDto.getVerifyStatus() != null, PmsProduct::getVerifyStatus, productQueryDto.getVerifyStatus())
                // 分类筛选
                .eq(productQueryDto.getProductCategoryId() != null, PmsProduct::getCategoryId, productQueryDto.getProductCategoryId())
                // 品牌筛选
                .eq(productQueryDto.getBrandId() != null, PmsProduct::getBrandId, productQueryDto.getBrandId())
                // 货号模糊查询
                .like(StringUtils.hasText(productQueryDto.getProductSn()), PmsProduct::getSn, productQueryDto.getProductSn());

        // 3. 分页查询
        IPage<PmsProduct> productPage = productMapper.selectPage(page, wrapper);

        // 4. 转换为通用分页结果（复用之前的CommonPage.restPage方法）
        return CommonPage.restPage(productPage);


    }
}
