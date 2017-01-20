package com.lov.entity;

import java.util.List;

/**
 * Created by liuw on 2017/1/19.
 */
public class UserPager extends  Pager {

    private List<User> users;
    public List<User> getList() {
        return users;
    }

    public void setList(List<User> users) {
        this.users = users;
    }
}
