package com.hafu.edu.teachingmanagementsystem.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Organization)实体类
 *
 * @author makejava
 * @since 2022-02-15 23:01:01
 */
public class Organization implements Serializable {
    private static final long serialVersionUID = -67285067431237721L;

    private Long collegeId;

    private String faculty;

    private String teachingResearch;

    private Date createTime;

    private Date modifiedTime;

    private String condition;


    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getTeachingResearch() {
        return teachingResearch;
    }

    public void setTeachingResearch(String teachingResearch) {
        this.teachingResearch = teachingResearch;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}

