package com.cloud.base.mapper.impl;

import com.cloud.base.domain.User;
import com.cloud.base.mapper.UserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Administrator
 * @date : 2017/3/10 0010
 * @Description:
 */
@Component
public class UserMapperImpl implements UserMapper{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return (User)sqlSessionTemplate.selectOne("com.cloud.base.mapper.UserMapper.selectByPrimaryKey",id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
