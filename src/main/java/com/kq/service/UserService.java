package com.kq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kq.dao.UserDao;
import com.kq.pojo.Student;
import com.kq.pojo.User;
import com.kq.utils.RequestUtils;
import com.kq.utils.result.ResponseBo;
import com.kq.utils.result.ResultUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserDao userDao;


    /**
     * 用户注册
     * @param user
     * @return
     */
    public ResponseBo addUser(User user){
        User checkUser = checkUser(user);
        if (checkUser!=null){
            return ResultUtils.error("用户名已存在,请重新输入!",false);
        }
        int i = userDao.addUser(user);
        System.out.println(i);
        if (i>0){
            return ResultUtils.success("注册成功！,等待管理员审核",true);
        }
        return ResultUtils.error("注册失败,请检查用户名或密码",false);
    }

    public ResponseBo Login(HttpServletRequest request,User user){
        User loginUser = userDao.Login(user);
//        System.err.println("loginUser"+loginUser);
        if (loginUser!=null){
            RequestUtils.setLoginUser(request,loginUser);
            if (loginUser.getUsername().equals("admin")){
                return ResultUtils.success("admin",true);
            }else {
                return ResultUtils.success("man",true);
            }
        }
        return ResultUtils.error("登录失败，请检查用户名或密码,联系管理员",false);
    }


    /**
     * 密码验证
     * @param request
     * @param password
     * @return
     */
    public ResponseBo checkPassword(HttpServletRequest request,String password){
        User loginUser = RequestUtils.getLoginUser(request);
        String oldPassWord = loginUser.getPassword();
        System.out.println(oldPassWord);
        System.out.println(password);
        if (password.equals(oldPassWord)){
                return ResultUtils.success("密码验证成功",true);
            }else {
                return ResultUtils.error("旧密码不正确",false);
            }
    }

    /**
     * 修改密码
     * @param request
     * @param password
     * @return
     */
    public ResponseBo updatePassword(HttpServletRequest request, String password){
        User loginUser = RequestUtils.getLoginUser(request);
        loginUser.setPassword(password);
        int i = userDao.updatePassword(loginUser);
        if (i>0){
            RequestUtils.Logout(request);
            return ResultUtils.success("修改成功",true);
        }

        return ResultUtils.success("修改失败",false);
    }


    /**
     * 获取新注册用户
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseBo getUserList(int currentPage, int pageSize){
        Page page = PageHelper.startPage(currentPage, pageSize);
        List<User> userList = userDao.getUserList();
        PageInfo pageInfo = new PageInfo(page);
        if (userList!=null){
            return ResultUtils.success("success",pageInfo);
        }
        return ResultUtils.error("暂无待处理消息!");
    }
    public PageInfo selectByPageOther(int currentPage, int pageSize){
        Page page = PageHelper.startPage(currentPage, pageSize);
        List<User> userList = userDao.getUserList();
        //封装Info对象
//        System.out.println(students);
        PageInfo pageInfo = new PageInfo(page);
        return pageInfo;
    }

    public ResponseBo getThings(){
        int thingsNum = userDao.getThings();
        if (thingsNum!=0){
            return ResultUtils.success("things",thingsNum);
        }
        return ResultUtils.error("暂无待处理消息");

    }

    public ResponseBo updateType(int type,int id,int currentPage, int pageSize){

        int i = userDao.updateType(id,type);
        if (i>0){
            PageInfo pageInfo = selectByPageOther(currentPage, pageSize);
            return ResultUtils.success("修改成功!",pageInfo);
        }
        return ResultUtils.error("修改失败!");
    }







    public User checkUser(User user){
        User registerCheck = userDao.CheckUserName(user.getUsername());
        return registerCheck;

    }
}
