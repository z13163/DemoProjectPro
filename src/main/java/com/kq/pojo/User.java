package com.kq.pojo;

import java.util.Date;

public class User {

    private int id;
    private String username;
    private String password;
    private Date birthday;
    private int age;
    private int type;

    public User() {
    }

    public User(int id, String username, String password, Date birthday, int age, int type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.age = age;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", type=" + type +
                '}';
    }
}
