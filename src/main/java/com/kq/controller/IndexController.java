package com.kq.controller;


import com.kq.pojo.User;
import com.kq.service.StudentService;
import com.kq.service.UserService;
import com.kq.utils.RequestUtils;
import com.kq.utils.result.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping
public class IndexController {

    private UserService userService;
    private StudentService studentService;
    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


    /**
     * 登录页
     * @return
     */
    @RequestMapping("/")
    public String login(){
        return "login";
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/RegisterSubmit")
    @ResponseBody
    public ResponseBo RegisterSubmit(User user){
        user.setBirthday(new Date());
        System.out.println(user);
        return userService.addUser(user);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/LoginSubmit")
    @ResponseBody
    public ResponseBo Login(HttpServletRequest request, User user){
        return userService.Login(request,user);
    }

    @RequestMapping(value = "/html/LogoutSubmit")
    @ResponseBody
    public Boolean Logout(HttpServletRequest request){
        Boolean logout = RequestUtils.Logout(request);
        return logout;
    }

    @RequestMapping(value = "/html/checkPass")
    @ResponseBody
    public ResponseBo checkPass(HttpServletRequest request,String password){
        return userService.checkPassword(request,password);
    }

    @RequestMapping(value = "/html/updatePass")
    @ResponseBody
    public ResponseBo updatePassword(HttpServletRequest request,String password){
        return userService.updatePassword(request, password);
    }

    @RequestMapping(value = "/html/UserList")
    @ResponseBody
    public ResponseBo UserList(int currentPage, int pageSize){
        return userService.getUserList(currentPage, pageSize);
    }

    @RequestMapping(value = "/html/getThings")
    @ResponseBody
    public ResponseBo getThings(){
        return userService.getThings();
    }

    @RequestMapping(value = "/html/updateType")
    @ResponseBody
    public ResponseBo updateType(int id,int currentPage, int pageSize,String method){
        int type = 2;
        if ("refuseUser".equals(method)){
            return userService.updateType(type,id,currentPage,pageSize);
        }
        System.err.println(type);
        type=1;
        return userService.updateType(type,id,currentPage,pageSize);
    }


    @RequestMapping(value = "/html/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(!file.isEmpty()){
//            String path = file.getOriginalFilename();
            // 文件保存路径
            String path = request.getSession().getServletContext().getRealPath("/") + "upload/"+ file.getOriginalFilename();
            if(!new File(path).exists()){
                new File(path).mkdirs();
            }
            file.transferTo(new File(path));
            System.out.println(path);
            return "redirect:success.html";
        }else{
            return "redirect:fail.html";
        }

    }




}
