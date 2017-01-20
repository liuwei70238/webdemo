package com.lov.service;

import com.lov.dao.UserDao;
import com.lov.entity.Pager;
import com.lov.entity.User;
import com.lov.entity.UserPager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.List;

/**
 * Created by liuw on 2017/1/12.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public Long saveUser(User user) {
        Long flag = userDao.save(user);
        return flag;

    }

    public List<User> findUser(User user) {
        return userDao.findUser(user.getUsername(), user.getPassword());

    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void modifyUser(User user) {
        userDao.modifyUser(user);
    }

    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    public UserPager queryUser(int currPage, int pageSize) {
        UserPager userPager = new UserPager();
        //总条数
        int allRow = userDao.getAllRowCount();
        //当前页开始记录
        int offset = userPager.countOffset(currPage,pageSize);
        List<User> users = userDao.queryUserForPager(offset,pageSize);
        userPager.setPageNo(currPage);
        userPager.setPageSize(pageSize);
        userPager.setTotalRecords(allRow);
        userPager.setList(users);
        userPager.setNextPage(userPager.getNextPageNo());
        userPager.setPreviousPageNo();
        userPager.setBottomPageNo(userPager.getTotalPages());
        return userPager;
    }

    public int getAllRowCount() {
        return userDao.getAllRowCount();
    }

    public User findUserById(long id) {
        return userDao.findUserById(id);
    }


}
