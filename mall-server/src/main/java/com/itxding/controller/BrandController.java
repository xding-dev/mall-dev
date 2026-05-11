package com.itxding.controller;

import com.itxding.entity.PageParam;
import com.itxding.entity.PmsBrand;
import com.itxding.result.CommonPage;
import com.itxding.result.Result;
import com.itxding.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
@Slf4j
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 根据品牌名称分页获取品牌列表
     * @param pageParam
     * @return
     */
    @GetMapping("/list")
    public Result<CommonPage<PmsBrand>> getBrandList(PageParam pageParam){
        log.info("根据品牌名称分页获取品牌列表，{}",pageParam);
        CommonPage<PmsBrand> commonPage = brandService.getBrandList(pageParam);
        return Result.success(commonPage);
    }
}
