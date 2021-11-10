package com.kq.dao;

import com.kq.pojo.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface TeacherDao {


    /**
     * 查询教师信息
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Teacher> queryAllTeacher(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    /**
     * 查询各班情况
     * @param shot
     * @return
     */
    List<Teacher> queryClazzCondition(@Param("shot") int shot,@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    /**
     * 查询教师接种情况和更新时间
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Teacher> queryByShot(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    /**
     * 新增教师
     * @param teacher
     * @return
     */
    int AddTeacher(Teacher teacher);

    /**
     * 修改教师信息
     * @param teacher
     * @return
     */
    int UpdateTeacher(Teacher teacher);


    /**
     * 删除教师信息
     * @param id
     * @return
     */
    @Delete("delete from teacher_tb where id=#{id}")
    int deleteTeacher(@Param("id") int id);

}
