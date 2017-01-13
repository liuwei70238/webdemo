package com.lov.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.lov.entity.User;
import com.lov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by liuw on 2017/1/12.
 */
@Controller
public class LoginCtrl {

    @Autowired
    UserService userService;
    @RequestMapping("/login-view.do")
    public ModelAndView login_view(){
        ModelAndView mv = new ModelAndView("login");
        return  mv;

    }

    @RequestMapping("/regist.do")
    public String regist(
           String username,
           String password,
           HttpServletResponse response
    ){

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        JSONObject json = new JSONObject();

        Long flag = userService.saveUser(user);
        if(flag > 0){
            json.put("code","success");
        }else{
            json.put("code","failure");
        }
        response.setContentType("application/json;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            out.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return  null;

    }
}
