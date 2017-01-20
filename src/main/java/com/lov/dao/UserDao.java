package com.lov.dao;

import com.lov.entity.User;

import java.util.List;


/**
 * Created by liuw on 2017/1/12.
 */
public interface UserDao {
    public Long save(User user);
    public  List<User> findUser(String username,String password);
    public User findUserById(long id);
    public List<User> findAll();
    public void modifyUser(User user);
    public void deleteUser(Long id);
    public List<User> queryUserForPager(int offset, int length);
    public int getAllRowCount();

}
