package com.cloud.base.service.impl;

import com.cloud.base.domain.User;
import com.cloud.base.mapper.UserMapper;
import com.cloud.base.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator
 * @date : 2017/7/26 0026
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByPrimaryKey(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
