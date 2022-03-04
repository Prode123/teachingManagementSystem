package com.hafu.edu.teachingmanagementsystem.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrizeExcel {

    @ExcelProperty("奖项名")
    private String pname;
    @ExcelProperty("奖项等级")
    private String level;
    @ExcelProperty("奖项分类")
    private String plevel;
    @ExcelProperty("发证机构")
    private String psponsor;
    @ExcelProperty("发证日期")
    private String ptime;
    @ExcelProperty("获奖者")
    private String isDelete;
    @ExcelProperty("指导老师")
    private String tname;
    @ExcelProperty("比赛类别")
    private String category;
    @ExcelProperty("称号")
    private String title;
    @ExcelProperty("证书编号")
    private String number;
    @ExcelProperty("学院")
    private String faculty ;
    @ExcelProperty("学年")
    private String grade;





}
