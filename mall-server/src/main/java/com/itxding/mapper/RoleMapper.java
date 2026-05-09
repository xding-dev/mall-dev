package com.itxding.mapper;

import com.itxding.entity.UmsAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select  * from ums_admin")
    List<UmsAdmin> getAllRoles();
}
