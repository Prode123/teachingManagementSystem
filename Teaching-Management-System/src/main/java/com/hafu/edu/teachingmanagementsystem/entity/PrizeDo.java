package com.hafu.edu.teachingmanagementsystem.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class PrizeDo {

    @ExcelProperty("奖项名")
    private String name;
    @ExcelProperty("奖项编号")
    private String number;

    public PrizeDo() {
    }

    public PrizeDo(String name, String number) {
        this.name = name;
        this.number = number;
    }

}
