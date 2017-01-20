package com.lov.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.lov.entity.User;
import com.lov.service.UserService;
import com.lov.util.NetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

    @RequestMapping("/regist-view.do")
    public ModelAndView regist_view(){
        ModelAndView mv = new ModelAndView("regist");
        return  mv;
    }

    @RequestMapping("/signin.do")
    public String regist(
           String username,
           String password,
           HttpServletResponse response
    ){

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAuthority(0);//非管理员

        JSONObject json = new JSONObject();

        Long flag = userService.saveUser(user);
        System.out.println("flag:" + flag);
        json.put("code",true);
//        if(flag >= 0){
//
//        }else{
//            json.put("code",false);
//        }
        NetUtil.pringJson(json,response);


        return  null;

    }

    @RequestMapping("/login.do")
    public String login(
            String username,
            String password,
            HttpServletResponse response,
            HttpServletRequest request
    ){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        List<User> users= userService.findUser(user);

        JSONObject r = new JSONObject();
        if(users.size() !=0){
            r.put("code",true);
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("authority",users.get(0).getAuthority());//权限
            System.out.println("authority: " + users.get(0).getAuthority());
        }else{
            r.put("code",false);
        }
        NetUtil.pringJson(r,response);

        //ModelAndView mv = new ModelAndView("index");
        return null;

    }

    @RequestMapping("/logout.do")
    public ModelAndView logout(
            HttpServletRequest request
    ){
        HttpSession httpSession =  request.getSession();
        httpSession.removeAttribute("username");
        httpSession.invalidate();
        ModelAndView mv = new ModelAndView("../../index");
        return mv;
    }
}
