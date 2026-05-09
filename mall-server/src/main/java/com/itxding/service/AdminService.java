package com.itxding.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itxding.entity.PageParam;
import com.itxding.entity.UmsAdmin;

public interface AdminService {
    /**
     *  分页获取用户列表（完全匹配前端接口）
     *
     * @param pageParam
     * @return
     */
    IPage<UmsAdmin> getAdminList(PageParam pageParam);
}
