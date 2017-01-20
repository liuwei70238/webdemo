package com.lov.dao;

import com.lov.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        Criteria cri = getCurrentSession().createCriteria(User.class);
        return cri.list();
    }

    public void modifyUser(User user) {
        System.out.println(getCurrentSession().getTransaction().isActive());
        getCurrentSession().update(user);
        getCurrentSession().flush();
    }

    public void deleteUser(Long id) {
        getCurrentSession().createQuery("delete User where id=?").setParameter(0, id).executeUpdate();;
    }

    public List<User> queryUserForPager(int offset, int length) {
        Query query = getCurrentSession().createQuery("from User");
        query.setFirstResult(offset);//该页的第一条
        query.setMaxResults(length);//每页条数
        return query.list();
    }

    public int getAllRowCount() {
        int count = ((Long)getCurrentSession().createQuery("select count(*) from User").iterate().next()).intValue();
        return count;
    }

    public List<User> findUser(String username, String password){
        List<User> list = new ArrayList<User>();
        if(username == null || password == null){
            return list;
        }else{
            String sql = "from User as user where user.username=:username and password=:password";
            Query query = getCurrentSession().createQuery(sql);
            query.setString("username",username);
            query.setString("password",password);
            list = query.list();
            System.out.println("size:" + list.size());
            return  list;
//            if(list.size() == 0){
//                return  false;
//            }else{
//
//                return true;
//            }
        }

    }

    public User findUserById(long id) {

        return (User) getCurrentSession().get(User.class,id);

    }
}
