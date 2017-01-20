package com.lov.service;


import com.lov.entity.Pager;
import com.lov.entity.User;
import com.lov.entity.UserPager;

import java.util.List;

/**
 * Created by liuw on 2017/1/12.
 */
public interface UserService {
    public Long saveUser(User user);

    public List<User> findUser(User user);

    //非分页查找所有用户
    public List<User> findAll();

    //修改用户
    public void modifyUser(User user);
    //删除用户.

    public void deleteUser(Long id);

    //分页查找
    public UserPager queryUser(int offset, int length);

    //得到总数
    public int getAllRowCount();

    //通过id拿到user
    public User findUserById(long id);

    ;
}
