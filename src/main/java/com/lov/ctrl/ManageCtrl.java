package com.lov.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.lov.entity.User;
import com.lov.entity.UserPager;
import com.lov.service.UserService;
import com.lov.util.NetUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by liuw on 2017/1/16.
 */
@Controller
public class ManageCtrl {

    @Autowired
    private UserService userService;
    @RequestMapping("/manage.do")
    public ModelAndView manage(
            HttpServletRequest request
    ){
        ModelAndView mv = new ModelAndView("manage");
        String pageNo = request.getParameter("pageNo");
        if(pageNo == null){
            pageNo = "1";
        }
        UserPager pager =  userService.queryUser(Integer.parseInt(pageNo),5);

        List<User> list = pager.getList();
        System.out.println("pager:" + pager.toString());
        mv.addObject("list",list);
        mv.addObject("page",pager);
        return  mv;
    }

    @RequestMapping("/modify_user.do")
    public String modify(
            String username,
            String password,
            int authority,
            Long id,
            HttpServletResponse response
    ){


        System.out.println("authority:" + authority);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAuthority(authority);
        user.setId(id);
        JSONObject r = new JSONObject();
        if(user !=null){
            userService.modifyUser(user);
            r.put("code",true);

        }else{
            r.put("code",false);
        }

        NetUtil.pringJson(r,response);
        return null;
    }

    @RequestMapping("/modify_view.do")
    public ModelAndView modify_view(
            String username,
            String password,
            int authority,
            Long id
    ){
        ModelAndView mv = new ModelAndView("modify_user");
        mv.addObject("username",username);
        mv.addObject("password",password);
        mv.addObject("authority",authority);
        mv.addObject("id",id);
        return  mv;
    }

    @RequestMapping("/delete_user.do")
    public String delete(
            Long id,
            HttpServletResponse response
    ){
        JSONObject r = new JSONObject();
        if(id!=null){
            userService.deleteUser(id);
            r.put("code",true);
        }else{
            r.put("code",false);
        }

        NetUtil.pringJson(r,response);
        return  null;
    }


}
