package com.hafu.edu.teachingmanagementsystem.entity;

import java.io.Serializable;

/**
 * (Permission)实体类
 *
 * @author makejava
 * @since 2022-02-06 17:46:23
 */
public class Permission implements Serializable {
    @Override
    public String toString() {
        return "Permission{" +
                "pid=" + pid +
                ", ctype='" + ctype + '\'' +
                ", restype='" + restype + '\'' +
                ", operation='" + operation + '\'' +
                ", purl='" + purl + '\'' +
                ", pname='" + pname + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return operation.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(!(obj instanceof Permission)){
            return false;
        }
        Permission p=(Permission)obj;
        return this.pid.equals(p.pid);
    }

    private static final long serialVersionUID = 687909408308401467L;

    private Long pid;

    private String ctype;

    private String restype;

    private String operation;

    private String purl;

    private String pname;

    private String roleId;


    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getRestype() {
        return restype;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}

