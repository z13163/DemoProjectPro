package com.kq.controller;


import com.kq.pojo.Student;
import com.kq.service.StudentService;
import com.kq.utils.jsonUtils.JsonUtils;
import com.kq.utils.result.ResponseBo;
import com.kq.utils.result.ResultUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping(value = "/html")
public class StudentController {

    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    /**
     * 分页查询数据
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/studentSubmit")
    @ResponseBody
    public ResponseBo selectByPage(HttpServletRequest request,Student student, int currentPage, int pageSize, Integer navigateLastPage, String method){

        System.out.println(request.getContextPath());
        System.out.println(student);
        System.out.println(currentPage);
        System.out.println(pageSize);
        System.out.println(method);
        //判断需要进行的操作
        if ("selectByPage".equals(method)){
            return studentService.selectByPage(currentPage, pageSize);
        }
        else if ("addStu".equals(method)){
            Student checkNumber = studentService.CheckNumber(student.getNumber());
            if (checkNumber!=null){
                return ResultUtils.error("学号已存在!!!");
            }
            return studentService.addStu(student,navigateLastPage,pageSize);
        }
        else if ("deleteStu".equals(method)){
            return studentService.deleteStu(student.getNumber(),currentPage,pageSize);
        }
        else if("updateStu".equals(method)){
            return studentService.updateStu(student,currentPage,pageSize);
        }
        return ResultUtils.error("出错了!");


    }

    @RequestMapping(value = "/queryShot")
    @ResponseBody
    public ResponseBo queryShot(Student student,String method,int currentPage, int pageSize){
        if ("selectByPage".equals(method)){
            return studentService.selectByShot(currentPage, pageSize);
        } else if ("updateStuno".equals(method)) {
            return studentService.updateShot(student,currentPage,pageSize);
        }else if ("querySearch".equals(method)){
            return studentService.querySearch(student, currentPage, pageSize);
        }

        return null;
    }


    /**
     * 学生地区数据接口
     * @return
     */
    @RequestMapping(value = "/selectByArea")
    @ResponseBody
    public ResponseBo selectByArea(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return studentService.selectByArea();
    }
    @RequestMapping(value = "/selectByAreaDesc")
    @ResponseBody
    public ResponseBo selectByAreaDesc(HttpServletResponse response, Integer limit){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return studentService.selectByAreaDesc(limit);
    }















//    @RequestMapping(value = "studentSubmit/addStu")
//    public ResponseBo addStu(Student student,int navigateLastPage,int pageSize){
//        Student checkNumber = studentService.CheckNumber(student.getNumber());
//        if (checkNumber!=null){
//            return ResultUtils.error("学号已存在!!!");
//        }
//        return studentService.addStu(student,navigateLastPage,pageSize);
//    }
}
