package com.kq.filter;

import com.kq.pojo.User;
import com.kq.utils.RequestUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PathFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        User loginUser = RequestUtils.getLoginUser(req);
        if (loginUser!=null){
            filterChain.doFilter(req,resp);
            return;
        }
        resp.sendRedirect(req.getContextPath()+"/");
    }

    public void destroy() {

    }
}
