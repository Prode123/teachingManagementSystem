package com.hafu.edu.teachingmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 程世玉
 * @create 2022/2/8 15:56
 * @PROJECT_NAME Teaching-Management-System
 * @Description  这个类是进行跳转页面用的
 */
@Controller
@CrossOrigin
public class JumpPageController {
    @RequestMapping("index.html")
    public String indexHtml(){
        return "index";
    }

    @RequestMapping("studentIndex.html")
    public String studentIndex(){
        return "page/studentIndex/index";
    }


    @RequestMapping("teacherIndex.html")
    public String teacherIndex(){
        return "page/teacherIndex/index";
    }

    @RequestMapping("c.html")
    public String cHtml(){
        return "c";
    }

    @RequestMapping("adminIndex.html")
    public String adminIndex(){
        return "page/adminIndex/index";
    }


    @RequestMapping("superAdminIndex.html")
    public String superAdminIndex(){
        return "page/superAdminIndex/index";
    }

}
