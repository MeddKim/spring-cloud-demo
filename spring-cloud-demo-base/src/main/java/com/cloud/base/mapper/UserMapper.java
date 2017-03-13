package com.cloud.base.mapper;

import com.cloud.base.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author: Administrator
 * @date : 2017/3/13 0013
 * @Description:
 */
@Mapper
public interface UserMapper {

    @Select(" SELECT * FROM sys_user WHERE id = #{id}")
    User selectByPrimaryKey(@Param("id") Long id);
}
