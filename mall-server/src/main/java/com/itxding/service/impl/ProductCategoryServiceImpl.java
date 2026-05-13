package com.itxding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itxding.entity.PageParam;
import com.itxding.entity.PmsCategory;
import com.itxding.entity.PmsProductCategoryExt;
import com.itxding.mapper.ProductCategoryMapper;
import com.itxding.result.CommonPage;
import com.itxding.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    /**
     * 查询所有一级分类及子分类
     * @return
     */
    public List<PmsProductCategoryExt> getProductCategoryListWithChildren() {
        // 1. 查询所有启用状态的分类（可根据需求调整，比如只查showStatus=1的）
        LambdaQueryWrapper<PmsCategory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PmsCategory::getShowStatus, 1); // 只返回启用的分类，适合前端下拉框
        List<PmsCategory> allCategories = productCategoryMapper.selectList(wrapper);

        // 2. 转换为扩展对象
        List<PmsProductCategoryExt> extList = allCategories.stream()
                .map(category -> {
                    PmsProductCategoryExt ext = new PmsProductCategoryExt();
                    // 复制父类所有字段
                    ext.setId(category.getId());
                    ext.setName(category.getName());
                    ext.setParentId(category.getParentId());
                    ext.setUnit(category.getUnit());
                    ext.setSort(category.getSort());
                    ext.setShowStatus(category.getShowStatus());
                    ext.setNavStatus(category.getNavStatus());
                    ext.setIcon(category.getIcon());
                    ext.setKeywords(category.getKeywords());
                    ext.setDescription(category.getDescription());
                    ext.setCreateTime(category.getCreateTime());
                    ext.setUpdateTime(category.getUpdateTime());
                    return ext;
                }).collect(Collectors.toList());

        // 3. 筛选一级分类（parentId=0），并递归构建子分类
        List<PmsProductCategoryExt> rootList = extList.stream()
                .filter(category -> category.getParentId() == 0)
                .collect(Collectors.toList());

        // 递归为每个一级分类设置子分类
        for (PmsProductCategoryExt root : rootList) {
            root.setChildren(getChildren(root.getId(), extList));
        }

        return rootList;
    }


    /**
     * 递归获取子分类（核心方法）
     * @param parentId 父分类ID
     * @param allList 所有分类列表
     * @return 子分类列表
     */
    private List<PmsProductCategoryExt> getChildren(Long parentId, List<PmsProductCategoryExt> allList) {
        // 筛选出parentId等于当前分类ID的所有子分类
        List<PmsProductCategoryExt> children = allList.stream()
                .filter(category -> category.getParentId().equals(parentId))
                .collect(Collectors.toList());

        // 递归设置子分类的子分类（支持无限层级）
        for (PmsProductCategoryExt child : children) {
            child.setChildren(getChildren(child.getId(), allList));
        }
        return children;
    }




    /**
     * 分页查询商品分类
     * @param parentId
     * @param pageParam
     * @return
     */
    public CommonPage<PmsCategory> getProductCategoryList(Long parentId, PageParam pageParam) {
        //1.构建分页对象
        Page<PmsCategory> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());
        //2.构建分页查询条件
        LambdaQueryWrapper<PmsCategory> wrapper = new LambdaQueryWrapper<>();
        // 按父ID筛选
        wrapper.eq(PmsCategory::getParentId, parentId)
                // 按分类名称模糊查询（keyword不为空时生效）
                .like(StringUtils.hasText(pageParam.getKeyword()), PmsCategory::getName, pageParam.getKeyword())
                // 按排序字段升序排列
                .orderByAsc(PmsCategory::getSort);
        //3.分页查询
        IPage<PmsCategory> categoryIPage = productCategoryMapper.selectPage(page, wrapper);

        //4.转换为通用分页结果
        return CommonPage.restPage(categoryIPage);
    }
}
