package com.kq.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kq.dao.StudentDao;
import com.kq.pojo.Area;
import com.kq.pojo.Student;
import com.kq.utils.jsonUtils.JsonUtils;
import com.kq.utils.result.ResponseBo;
import com.kq.utils.result.ResultUtils;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class StudentService {

    @Resource
    private StudentDao studentDao;

    /**
     * PageHelper分页查询数据
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageInfo selectByPageOther(int currentPage, int pageSize){
        Page page = PageHelper.startPage(currentPage, pageSize);
        List<Student> students = studentDao.selectAll(currentPage, pageSize);
        //封装Info对象
//        System.out.println(students);
        PageInfo pageInfo = new PageInfo(page);
        return pageInfo;
    }

    public ResponseBo selectByPage(int currentPage, int pageSize){

        Page page = PageHelper.startPage(currentPage, pageSize);
        List<Student> students = studentDao.selectAll(currentPage, pageSize);
        //封装Info对象
//        System.out.println(students);
        PageInfo pageInfo = new PageInfo(page);
        if (students==null){
            return ResultUtils.error("出错了!暂无信息!");
        }
            return ResultUtils.success("success",pageInfo);
    }

    public ResponseBo addStu(Student student,int navigateLastPage, int pageSize){
        try{
            Date date = JsonUtils.TimestampToDate(student.getBirthday());
            student.setBirthday(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        //给学生分配班级
        int clazz = queryClazz();
        student.setClazzId(clazz);
        System.err.println(clazz);
        int i = studentDao.addStu(student);
        PageInfo pageInfo = selectByPageOther(navigateLastPage, pageSize);
        if (i>0){
            if (pageInfo.getNavigateLastPage()!=navigateLastPage){
                PageInfo pageInfo1 = selectByPageOther(pageInfo.getNavigateLastPage(), pageSize);
                return ResultUtils.success("添加成功! ! !",pageInfo1);
            }
            return ResultUtils.success("添加成功! ! !",pageInfo);
        }
        return ResultUtils.error("新增失败!");


    }

    public ResponseBo updateStu(Student student,int currentPage, int pageSize){
        try{
            Date date = JsonUtils.TimestampToDate(student.getBirthday());
            student.setBirthday(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        int i = studentDao.updateStu(student);
        if (i>0){
            PageInfo pageInfo = selectByPageOther(currentPage, pageSize);
            return ResultUtils.success("修改成功! ! !",pageInfo);
        }
        return ResultUtils.error("修改失败! ! !");
    }

    public ResponseBo deleteStu(int number,int currentPage, int pageSize){
        int i = studentDao.deleteStu(number);
        PageInfo pageInfo = selectByPageOther(currentPage, pageSize);
        if (i>0){
            if (pageInfo.getNavigateLastPage()!=currentPage){
                PageInfo pageInfo1 = selectByPageOther(pageInfo.getNavigateLastPage(), pageSize);
                return ResultUtils.success("删除成功! ! !",pageInfo1);
            }
            return ResultUtils.success("删除成功! ! !",pageInfo);
        }
        return ResultUtils.error("删除失败! ! !");

    }

    /**
     * selectByShot
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseBo selectByShot(int currentPage, int pageSize){

        Page page = PageHelper.startPage(currentPage, pageSize);
        List<Student> students = studentDao.selectByShot(currentPage, pageSize);
        //封装Info对象
        System.out.println(students);
        PageInfo pageInfo = new PageInfo(page);
        if (students==null){
            return ResultUtils.error("出错了!暂无信息!");
        }
        return ResultUtils.success("success",pageInfo);
    }


    /**
     * updateShot
     * @param student
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseBo updateShot(Student student, int currentPage, int pageSize){
        student.setLastUpdate(new Date());
        int i = studentDao.updateShot(student);
        if (i>0){
            Page page = PageHelper.startPage(currentPage, pageSize);
            List<Student> students = studentDao.selectByShot(currentPage, pageSize);
            //封装Info对象
            System.out.println(students);
            PageInfo pageInfo = new PageInfo(page);
            return ResultUtils.success("更新成功!",pageInfo);
        }
        return ResultUtils.error("更新失败! ! !");
    }

    public ResponseBo querySearch(Student student,int currentPage, int pageSize){
        Page page = PageHelper.startPage(currentPage, pageSize);
        String name = student.getName();
        List<Student> students = studentDao.querySearch(name,currentPage,pageSize);
        PageInfo pageInfo = new PageInfo(page);
        return ResultUtils.success("success",pageInfo);
    }


    /**
     * 地区数据分析
     * @return
     */
    public ResponseBo selectByArea(){
        List<Area> areas = studentDao.selectByArea();
        return ResultUtils.success("地区数据获取成功!",areas);
    }

    /**
     * 地区数据排序
     * @return
     */
    public ResponseBo selectByAreaDesc(int limit){
        List<Area> areas = studentDao.selectByAreaDesc(limit);
        return ResultUtils.success("地区数据获取成功!",areas);
    }


    public Student CheckNumber(int number){
        Student student = studentDao.CheckNumber(number);
        return student;
    }


    public int queryClazz(){
        List list = studentDao.queryClazz();
//        for (Object o : list) {
//            System.out.println(o);
//        }
//        System.out.println(list.size());
        Random random = new Random();
        int i = random.nextInt(list.size());
        while (i==0){
            random.nextInt(list.size());
        }
        return i;
    }





    //日期转换  时间戳转时间
//    public void dateConvert(){
//        ConvertUtils.register(new Converter() {
//            public Object convert(Class type, Object value) {
//                //格式化工具
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                try{
//                    return simpleDateFormat.parse(value.toString());
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//                return null;
//            }
//        }, Date.class);
//    }
}
