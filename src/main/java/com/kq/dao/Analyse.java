package com.kq.dao;


import com.kq.pojo.Sum;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Analyse {

    /**
     * 查询计数数据
     * @return
     */
    List<Sum> queryAllSum();


    /**
     * 查询教师计数
     * @return
     */
    List<Sum> queryAllTeacher();
}
