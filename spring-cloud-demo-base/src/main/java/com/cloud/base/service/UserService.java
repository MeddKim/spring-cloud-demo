package com.cloud.base.service;

import com.cloud.base.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator
 * @date : 2017/7/26 0026
 * @Description:
 */
public interface UserService {

    User findUserByPrimaryKey(Long id);
}
