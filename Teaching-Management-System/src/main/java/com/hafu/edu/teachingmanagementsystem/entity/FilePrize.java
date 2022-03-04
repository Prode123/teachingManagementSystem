package com.hafu.edu.teachingmanagementsystem.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FilePrize {
    private int pageNum;
    private int pageSize;
    private int uid;
    private int fileType;
    private String major;
    private String semester;
    private String fileName;
    private int  status;
    private ArrayList<String> statusList;
    private int condition;
    private int tors;
    private List<Integer> sta;
}
