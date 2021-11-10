package com.kq.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Teacher {

    private int id;
    private String name;
    private String sex;
    private String clazzName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private int CountNumber;
    private int ClazzNumberCount;
    private int shot;
    private int clazzId;
    private Date lastUpdate;

    //引入从表实体
    private Student student;
    private Clazz clazz;

    public Teacher() {
    }

    public Teacher(int id, String name, String sex, String clazzName, Date birthday, int countNumber, int clazzNumberCount, int shot, int clazzId, Date lastUpdate, Student student, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.clazzName = clazzName;
        this.birthday = birthday;
        CountNumber = countNumber;
        ClazzNumberCount = clazzNumberCount;
        this.shot = shot;
        this.clazzId = clazzId;
        this.lastUpdate = lastUpdate;
        this.student = student;
        this.clazz = clazz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getCountNumber() {
        return CountNumber;
    }

    public void setCountNumber(int countNumber) {
        CountNumber = countNumber;
    }

    public int getClazzNumberCount() {
        return ClazzNumberCount;
    }

    public void setClazzNumberCount(int clazzNumberCount) {
        ClazzNumberCount = clazzNumberCount;
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

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", clazzName='" + clazzName + '\'' +
                ", birthday=" + birthday +
                ", CountNumber=" + CountNumber +
                ", ClazzNumberCount=" + ClazzNumberCount +
                ", shot=" + shot +
                ", clazzId=" + clazzId +
                ", lastUpdate=" + lastUpdate +
                ", student=" + student +
                ", clazz=" + clazz +
                '}';
    }
}
