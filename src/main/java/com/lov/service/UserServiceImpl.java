package com.lov.service;

import com.lov.dao.UserDao;
import com.lov.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;

/**
 * Created by liuw on 2017/1/12.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    public Long saveUser(User user) {
        Long flag = userDao.save(user);
        return  flag;

    }
}
