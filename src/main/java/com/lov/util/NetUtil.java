package com.lov.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by liuw on 2017/1/16.
 */
public class NetUtil {

    public static void pringJson(JSONObject json,HttpServletResponse response){
        response.setContentType("application/json;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            out.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
