package com.hafu.edu.teachingmanagementsystem.entity;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Prize)实体类
 *
 * @author makejava
 * @since 2022-02-06 17:46:37
 */
@Data
public class Prize implements Serializable {

    private static final long serialVersionUID = 586235724224529977L;

    private Long pizId;

    private Date ptime;

    private String pwinner;

    private String psponsor;

    private String plevel;

    private Long category;

    private String title;

    private String number;

    private String pname;

    private String tid;

    private String tname;

    private String pathFront;

    private Date createTime;

    private Date modifiedTime;

    private Long uid;

    private String faculty;

    private String grade;

    private Integer status;

    private String reason;

    private Long auditId;

    private String isDelete;

    private String level;

    private List<Integer> sta;

//   上传的多个奖项图片
//    private List<String> picture;
//    上传的多个获奖用户id (包括所有的获奖学生和指导老师)
//    private List<Integer> id;



}

