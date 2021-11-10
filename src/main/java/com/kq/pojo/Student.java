package com.kq.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student {

    private int number;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String address;
    private int shot;
    private int clazzId;
    private String clazzName;
    private Date lastUpdate;


    public Student() {
    }

    public Student(int number, String name, Date birthday, String address, int shot, int clazzId, String clazzName, Date lastUpdate) {
        this.number = number;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.shot = shot;
        this.clazzId = clazzId;
        this.clazzName = clazzName;
        this.lastUpdate = lastUpdate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getShot() {
        return shot;
    }

    public void setShot(int shot) {
        this.shot = shot;
    }

    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", shot=" + shot +
                ", clazzId=" + clazzId +
                ", clazzName='" + clazzName + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
