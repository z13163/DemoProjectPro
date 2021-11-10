package com.kq.controller;


import com.kq.pojo.Teacher;
import com.kq.service.TeacherService;
import com.kq.utils.result.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/html")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "/queryAllTeacher")
    @ResponseBody
    public ResponseBo AllTeacher(int currentPage, int pageSize) {
        return teacherService.queryAllTeacher(currentPage, pageSize);
    }

    @RequestMapping(value = "/queryByTeacherShot")
    @ResponseBody
    public ResponseBo queryByTeacherShot(Teacher teacher, int currentPage, int pageSize, String method) {
        if ("updateTeaShot".equals(method)) {
            return teacherService.UpdateTeacher(teacher, currentPage, pageSize);
        }
        return teacherService.queryByShot(currentPage, pageSize);
    }

    @RequestMapping(value = "/teacherSubmit")
    @ResponseBody
    public ResponseBo teacherSubmit(Teacher teacher, int currentPage, int pageSize, Integer navigateLastPage, String method) {
        if ("addTea".equals(method)) {
            return teacherService.AddTeacher(teacher, currentPage, pageSize);
        } else if ("UpdateTeacher".equals(method)) {
            return teacherService.UpdateTeacher(teacher, currentPage, pageSize);
        } else if ("delTeacher".equals(method)) {
            return teacherService.delTeacher(teacher.getId(), currentPage, pageSize);
        }
        return null;
    }


    @RequestMapping(value = "/queryClazzCondition")
    @ResponseBody
    public ResponseBo queryClazzCondition(Integer shot, int currentPage, int pageSize) {
        return teacherService.queryClazzCondition(shot, currentPage, pageSize);
    }
}
