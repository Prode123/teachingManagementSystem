package com.hafu.edu.teachingmanagementsystem.entity;

import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2022-02-06 17:45:40
 */
public class Course implements Serializable {
    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", roleId='" + roleId + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }

    private static final long serialVersionUID = -27671796020433897L;

    private Long cid;

    private String roleId;

    private String describe;


    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

}

