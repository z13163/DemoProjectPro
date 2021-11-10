package com.kq.dao;


import com.kq.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {


    /**
     * 用户注册
     * @param user
     * @return
     */
//    @Insert("insert into user_tb values(#{id},#{username},#{password},#{birthday},#{age})")
    public int addUser(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
//    @Select("select * from user_tb where username=#{user.username} and password=#{user.password}")
    User Login(@Param("user") User user);


    /**
     * 用户注册校验
     * @param username
     * @return
     */
    User CheckUserName(String username);

    /**
     * 修改用户密码
     * @param user
     * @return
     */
    int updatePassword(User user);


    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();

    /**
     * 获取待处理消息
     * @return
     */
    int getThings();


    /**
     * 修改用户状态
     * @param id
     * @return
     */
    int updateType(@Param("id") int id,@Param("type") int type);
}
