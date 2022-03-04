package com.hafu.edu.teachingmanagementsystem.entity;

import java.io.Serializable;

/**
 * (Courseinformation)实体类
 *
 * @author makejava
 * @since 2022-02-22 15:58:53
 */
public class Courseinformation implements Serializable {
    private static final long serialVersionUID = 766192107027749059L;

    private Integer id;

    private String courseName;

    private String major;

    private String grade;

    private String semester;

    private String level;

    private String collegeName;

    private String waitingVariable1;

    private String waitingVariable2;

    private String waitingVariable3;

    private String roleId;

    private String describe;

    private Integer cid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getWaitingVariable1() {
        return waitingVariable1;
    }

    public void setWaitingVariable1(String waitingVariable1) {
        this.waitingVariable1 = waitingVariable1;
    }

    public String getWaitingVariable2() {
        return waitingVariable2;
    }

    public void setWaitingVariable2(String waitingVariable2) {
        this.waitingVariable2 = waitingVariable2;
    }

    public String getWaitingVariable3() {
        return waitingVariable3;
    }

    public void setWaitingVariable3(String waitingVariable3) {
        this.waitingVariable3 = waitingVariable3;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

}

