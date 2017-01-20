package com.lov.ctrl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liuw on 2017/1/19.
 */
@Controller
public class FamilyCtrl {

    @RequestMapping("/family.do")
    public ModelAndView view(
            HttpServletRequest request
    ){
        ModelAndView mv = new ModelAndView("family_tree");
        return  mv;
    }


}
