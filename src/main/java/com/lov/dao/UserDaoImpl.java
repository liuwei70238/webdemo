package com.lov.dao;

import com.lov.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liuw on 2017/1/12.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return  sessionFactory.getCurrentSession();
    }
    public Long save(User user) {

        if(user ==null){
            return 0l;
        }else{
            return (Long)getCurrentSession().save(user);
        }

    }

    public List<User> findAll() {
        return null;
    }
}
