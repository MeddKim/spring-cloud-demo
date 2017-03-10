package com.cloud.base.mapper;

import com.cloud.base.domain.UserAppRole;

public interface UserAppRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAppRole record);

    int insertSelective(UserAppRole record);

    UserAppRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAppRole record);

    int updateByPrimaryKey(UserAppRole record);
}