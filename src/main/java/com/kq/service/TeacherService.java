package com.kq.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kq.dao.TeacherDao;
import com.kq.pojo.Student;
import com.kq.pojo.Teacher;
import com.kq.utils.jsonUtils.JsonUtils;
import com.kq.utils.result.ResponseBo;
import com.kq.utils.result.ResultUtils;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TeacherService {
    @Resource
    private TeacherDao teacherDao;
    @Resource
    private StudentService studentService;

    //分页
    public PageInfo selectByPage(int currentPage, int pageSize){
        Page page = PageHelper.startPage(currentPage, pageSize);
        List<Teacher> teachers = teacherDao.queryAllTeacher(currentPage, pageSize);
        //封装Info对象
        PageInfo pageInfo = new PageInfo(page);
        return pageInfo;
    }

    /**
     * 查询教师列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseBo queryAllTeacher(int currentPage, int pageSize){
        PageInfo pageInfo = selectByPage(currentPage, pageSize);
        return ResultUtils.success("分页查询成功!",pageInfo);
    }

    /**
     * 查询教师接种情况和最后更新时间
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseBo queryByShot(int currentPage, int pageSize){
        Page page = PageHelper.startPage(currentPage, pageSize);
        List<Teacher> teachers = teacherDao.queryByShot(currentPage, pageSize);
        PageInfo pageInfo = new PageInfo(page);
        return ResultUtils.success("查询成功!",pageInfo);
    }

    /**
     * 添加教师
     * @param teacher
     * @param navigateLastPage
     * @param pageSize
     * @return
     */
    public ResponseBo AddTeacher(Teacher teacher,int navigateLastPage, int pageSize){
        try{
            Date date = JsonUtils.TimestampToDate(teacher.getBirthday());
            teacher.setBirthday(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        //分配班级
        int clazz = studentService.queryClazz();
        teacher.setClazzId(clazz);
        System.err.println(clazz);
        teacher.setLastUpdate(new Date());
        int i = teacherDao.AddTeacher(teacher);
        PageInfo pageInfo = selectByPage(navigateLastPage, pageSize);
        if (i>0){
            if (pageInfo.getNavigateLastPage()!=navigateLastPage){
                PageInfo pageInfo1 = selectByPage(pageInfo.getNavigateLastPage(), pageSize);
                return ResultUtils.success("新增成功!",pageInfo1);
            }
            return ResultUtils.success("添加成功!",pageInfo);

        }
        return ResultUtils.error("新增失败!",false);
    }

    /**
     * 更新教师信息
     * @param teacher
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseBo UpdateTeacher(Teacher teacher,int currentPage, int pageSize){
        teacher.setLastUpdate(new Date());
        int i = teacherDao.UpdateTeacher(teacher);
        if (i>0){
            Page page= PageHelper.startPage(currentPage,pageSize);
            List<Teacher> teachers = teacherDao.queryAllTeacher(currentPage, pageSize);
            PageInfo pageInfo = new PageInfo(page);
            return ResultUtils.success("更新成功!",pageInfo);
        }
        return ResultUtils.error("更新失败!");
    }

    public ResponseBo delTeacher(int id,int currentPage, int pageSize){
        int i = teacherDao.deleteTeacher(id);
        PageInfo pageInfo = selectByPage(currentPage, pageSize);
        if (i>0){
            if (pageInfo.getNavigateLastPage()!=currentPage){
                PageInfo pageInfo1 = selectByPage(pageInfo.getNavigateLastPage(), pageSize);
                return ResultUtils.success("删除成功! ! !",pageInfo1);
            }
            return ResultUtils.success("删除成功! ! !",pageInfo);
        }
        return ResultUtils.error("删除失败! ! !");
    }

    /**
     * 查询各班情况
     * @param shot
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseBo queryClazzCondition(Integer shot,int currentPage, int pageSize){
        Page page = PageHelper.startPage(currentPage, pageSize);
        List<Teacher> teachers = teacherDao.queryClazzCondition(shot,currentPage,pageSize);
        //封装Info对象
        PageInfo pageInfo = new PageInfo(page);
//        for (Teacher teacher : teachers) {
//            System.out.println(teacher);
//        }
        System.out.println(pageInfo);
        return ResultUtils.success(pageInfo);
    }
}
