package com.hafu.edu.teachingmanagementsystem.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Document)实体类
 *
 * @author makejava
 * @since 2022-02-06 17:45:55
 */
@Data
public class Document implements Serializable {
//    @Override
//    public String toString() {
//        return "Document{" +
//                "did=" + did +
//                ", path='" + path + '\'' +
//                ", size=" + size +
//                ", fileName='" + fileName + '\'' +
//                ", fileType=" + fileType +
//                ", createTime=" + createTime +
//                ", modifiedTime=" + modifiedTime +
//                ", grade='" + grade + '\'' +
//                ", semester=" + semester +
//                ", faculty='" + faculty + '\'' +
//                ", major='" + major + '\'' +
//                ", uid=" + uid +
//                ", status=" + status +
//                ", reason='" + reason + '\'' +
//                ", auditId=" + auditId +
//                ", course='" + course + '\'' +
//                ", level=" + level +
//                '}';
//    }

    private static final long serialVersionUID = 968736440288456720L;

    private Long did;

    private String path;

    private Long size;

    private String fileName;

    private Integer fileType;

    private Date createTime;

    private Date modifiedTime;

    private String grade;

    private String semester;

    private String faculty;

    private String major;

    private Integer uid;

    private Integer status;

    private String reason;

    private Integer auditId;

    private String course;

    private Integer level;

    private List<Integer> sta;

//
//    public Long getDid() {
//        return did;
//    }
//
//    public void setDid(Long did) {
//        this.did = did;
//    }
//
//    public String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }
//
//    public Long getSize() {
//        return size;
//    }
//
//    public void setSize(Long size) {
//        this.size = size;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public Integer getFileType() {
//        return fileType;
//    }
//
//    public void setFileType(Integer fileType) {
//        this.fileType = fileType;
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getModifiedTime() {
//        return modifiedTime;
//    }
//
//    public void setModifiedTime(Date modifiedTime) {
//        this.modifiedTime = modifiedTime;
//    }
//
//    public String getGrade() {
//        return grade;
//    }
//
//    public void setGrade(String grade) {
//        this.grade = grade;
//    }
//
//    public Integer getSemester() {
//        return semester;
//    }
//
//    public void setSemester(Integer semester) {
//        this.semester = semester;
//    }
//
//    public String getFaculty() {
//        return faculty;
//    }
//
//    public void setFaculty(String faculty) {
//        this.faculty = faculty;
//    }
//
//    public String getMajor() {
//        return major;
//    }
//
//    public void setMajor(String major) {
//        this.major = major;
//    }
//
//    public Integer getUid() {
//        return uid;
//    }
//
//    public void setUid(Integer uid) {
//        this.uid = uid;
//    }
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//    public String getReason() {
//        return reason;
//    }
//
//    public void setReason(String reason) {
//        this.reason = reason;
//    }
//
//    public Integer getAuditId() {
//        return auditId;
//    }
//
//    public void setAuditId(Integer auditId) {
//        this.auditId = auditId;
//    }
//
//    public String getCourse() {
//        return course;
//    }
//
//    public void setCourse(String course) {
//        this.course = course;
//    }
//
//    public Integer getLevel() {
//        return level;
//    }
//
//    public void setLevel(Integer level) {
//        this.level = level;
//    }

}

