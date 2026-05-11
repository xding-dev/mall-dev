package com.itxding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itxding.dto.ProductPublishStatusDTO;
import com.itxding.dto.ProductQueryDto;
import com.itxding.entity.PmsProduct;
import com.itxding.mapper.ProductMapper;
import com.itxding.result.CommonPage;
import com.itxding.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * 批量上下架商品
     * @param paramDTO
     */
    public void productUpdatePublishStatus(ProductPublishStatusDTO paramDTO) {
       //1.1参数校验
        if(paramDTO == null
        || !StringUtils.hasText(paramDTO.getIds())
        || paramDTO.getPublishStatus() == null){
            throw new RuntimeException("参数不能为空");
        }
        //1.2 检验状态只能为0或者1
        if (paramDTO.getPublishStatus() != 0 && paramDTO.getPublishStatus() != 1) {
            throw new RuntimeException("上架状态只能够为0或者1");
        }

        // 2. 分割逗号分隔的ID字符串，转为List<Long>
        List<Long> productIds;
        try {
            productIds = Arrays.stream(paramDTO.getIds().split(","))
                    .filter(StringUtils::hasText) // 过滤空字符串
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("商品ID格式不正确，请检查是否为数字");
        }

        // 3. 批量更新状态（MyBatis-Plus 批量更新语法）
        LambdaUpdateWrapper<PmsProduct> updateWrapper = new LambdaUpdateWrapper<>();
        // 设置状态为目标值
        updateWrapper.set(PmsProduct::getStatus, paramDTO.getPublishStatus())
                // 条件：ID在传入的列表中
                .in(PmsProduct::getId, productIds);
        // 执行更新（null表示不更新实体本身，只按条件更新）
        productMapper.update(null, updateWrapper);


    }
}
