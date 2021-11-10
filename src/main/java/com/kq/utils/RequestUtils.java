package com.kq.utils;

import com.kq.pojo.User;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
    private static final String LOGIN_USER_KEY = "loginUser";

    /**
     * 设置登录用户session
     * @param request
     */
    public static void setLoginUser(HttpServletRequest request, User loginUser){
        request.getSession().setAttribute(LOGIN_USER_KEY,loginUser);
    }

    /**
     * 根据请求获取当前登录用户
     * @param request 请求
     * @return
     */
    public static User getLoginUser(HttpServletRequest request){
        return (User)request.getSession().getAttribute(LOGIN_USER_KEY);
    }

    /**
     * 退出登录方法
     * @param request
     */
    public static Boolean Logout(HttpServletRequest request){
        if (request.getSession().getAttribute(LOGIN_USER_KEY)!=null){
            request.getSession().removeAttribute(LOGIN_USER_KEY);
            return true;
        }
        return false;
    }
}
