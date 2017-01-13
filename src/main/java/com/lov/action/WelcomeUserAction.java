package com.lov.action;

/**
 * Created by liuw on 2017/1/11.
 */
public class WelcomeUserAction {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // all struts logic here
    public String execute() {

        return "SUCCESS";

    }
}
