package com.hafu.edu.teachingmanagementsystem.entity;


import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-02-06 17:46:53
 */

public class User implements Serializable {
    private static final long serialVersionUID = 107956581607587931L;

    private Long uid;

    private String username;

    private String roleId;

    private String passwd;

    private String number;

    private String identityCard;

    private String phoneNumber;

    private Integer status;

    private Date createTime;

    private Date modifiedTime;

    private Integer sex;

    private String clazz;

    private String faculty;

    private String title;

    private String grade;

    private String major;

    private Integer level;

    private String teachingResearch;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getTeachingResearch() {
        return teachingResearch;
    }

    public void setTeachingResearch(String teachingResearch) {
        this.teachingResearch = teachingResearch;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", roleId='" + roleId + '\'' +
                ", passwd='" + passwd + '\'' +
                ", number='" + number + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                ", sex=" + sex +
                ", clazz='" + clazz + '\'' +
                ", faculty='" + faculty + '\'' +
                ", title='" + title + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", level=" + level +
                ", teachingResearch='" + teachingResearch + '\'' +
                '}';
    }
}

