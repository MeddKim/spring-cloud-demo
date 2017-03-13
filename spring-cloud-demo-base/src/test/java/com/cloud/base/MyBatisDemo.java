package com.cloud.base;

import com.cloud.base.mapper.UserMapper;
import com.cloud.base.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * @author: Administrator
 * @date : 2017/3/10 0010
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisDemo {

    @Autowired
    public UserMapper userMapper;

    @Test
    public void showData(){
        User user = userMapper.selectByPrimaryKey(1L);
        System.out.println(user.getUsername());
    }
}
