package com.lov.dao;

import com.lov.entity.User;

import java.util.List;


/**
 * Created by liuw on 2017/1/12.
 */
public interface UserDao {
    public Long save(User user);
    public List<User> findAll();
}
