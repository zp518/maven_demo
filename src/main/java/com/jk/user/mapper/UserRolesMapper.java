package com.jk.user.mapper;

import com.jk.user.model.UserRoles;

public interface UserRolesMapper {
    int deleteByPrimaryKey(Integer userrolesid);

    int insert(UserRoles record);

    int insertSelective(UserRoles record);

    UserRoles selectByPrimaryKey(Integer userrolesid);

    int updateByPrimaryKeySelective(UserRoles record);

    int updateByPrimaryKey(UserRoles record);
}