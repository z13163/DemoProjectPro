package com.kq.dao;


import com.kq.pojo.Area;
import com.kq.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Select("select * from student_tb")
    List<Student> selectAll(@Param("currentPage") int currentPage,@Param("pageSize") int pageSize);


    /**
     * 新增
     * @param student
     * @return
     */
    int addStu(Student student);

    /**
     * 查询现有班级列表
     * @return
     */
    List queryClazz();


    /**
     * 更新学生信息
     * @param student
     * @return
     */
    int updateStu(Student student);

    /**
     * 删除学生信息
     * @param number
     * @return
     */
    @Delete("delete from student_tb where number=#{number}")
    int deleteStu(@Param("number") int number);


    /**
     * 添加时验证学号
     * @param number
     * @return
     */
    @Select("select * from student_tb where number=#{number}")
    Student CheckNumber(@Param("number") int number);

    /**
     * 模糊查询姓名
     * @param name
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Student> querySearch(@Param("name") String name,int currentPage, int pageSize);

    /**
     * 查询数据(0,1,2)
     * @param currentPage
     * @param pageSize
     * @return
     */

    List<Student> selectByShot(@Param("currentPage") int currentPage,@Param("pageSize") int pageSize);

    /**
     * updateShot
     * @param student
     * @return
     */
    int updateShot(Student student);


    /**
     * 地区数据分析
     * @return
     */
    List<Area> selectByArea();

    /**
     * 地区数据排序分析
     * @return
     */
    List<Area> selectByAreaDesc(@Param("limit") int limit);

}
