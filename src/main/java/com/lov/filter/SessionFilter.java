package com.lov.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liuw on 2017/1/19.
 */
public class SessionFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        if(request.getSession().getAttribute("username")==null){
            response.sendRedirect(request.getContextPath()+"/login.do");

        }
        filterChain.doFilter(request, response);
    }

    public void destroy() {

    }
}
