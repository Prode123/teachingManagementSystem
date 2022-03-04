package com.hafu.edu.teachingmanagementsystem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserImages)实体类
 *
 * @author makejava
 * @since 2022-02-06 17:47:15
 */
public class UserImages implements Serializable {
    @Override
    public String toString() {
        return "UserImages{" +
                "useId=" + useId +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                ",uid" + uid +
                '}';
    }

    private static final long serialVersionUID = -28433834015555288L;

    private Long useId;

    private String path;

    private Long size;

    private Date createTime;

    private Date modifiedTime;

    private Long uid;


    public Long getUseId() {
        return useId;
    }

    public void setUseId(Long useId) {
        this.useId = useId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
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

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}

