package com.kq.pojo;

public class Clazz {

    private int id;
    private int teacherId;
    private String clazzName;

    public Clazz() {
    }

    public Clazz(int id, int teacherId, String clazzName) {
        this.id = id;
        this.teacherId = teacherId;
        this.clazzName = clazzName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", clazzName='" + clazzName + '\'' +
                '}';
    }
}
