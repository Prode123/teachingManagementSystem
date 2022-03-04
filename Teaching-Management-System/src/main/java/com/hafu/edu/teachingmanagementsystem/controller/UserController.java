package com.hafu.edu.teachingmanagementsystem.controller;

import com.hafu.edu.teachingmanagementsystem.Config.MyuserDetailsService;
import com.hafu.edu.teachingmanagementsystem.Config.SpringSecurityUser;
import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.entity.Courseinformation;
import com.hafu.edu.teachingmanagementsystem.entity.Organization;
import com.hafu.edu.teachingmanagementsystem.entity.User;
import com.hafu.edu.teachingmanagementsystem.entity.VerifyCode;
import com.hafu.edu.teachingmanagementsystem.service.CourseinformationService;
import com.hafu.edu.teachingmanagementsystem.service.OrganizationService;
import com.hafu.edu.teachingmanagementsystem.service.UserImagesService;
import com.hafu.edu.teachingmanagementsystem.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 程世玉
 * @create 2022/2/6 19:13
 * @PROJECT_NAME Teaching-Management-System
 * @Description 用户操作类,关于用户的一些操作
 *                  1、用户（学生，教师、管理员）登录      toLogin
 *                  2、查询个人信息                     getUser
 *                  3、查询头像                        getHeadImage
 *                  4、修改头像                        updateHeadImage
 *                  5、修改密码（管理员/用户）           updatePw
 *                  6、获取验证码                      getCode
 *                  7、查询学院列表                  getCollegeList
 *                  8、查询课程名                    getCourseInformation
 *
 */



@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private UserImagesService userImagesService;

    @Autowired
    private CourseinformationService courseInformationService;

    /**
     * @Description: 登录成功
     * @Param: session 将数据给前端页面
     * @return: 返回json
     * @Author: 程世玉
     * @Date: 2022/2/9
     */
    @SneakyThrows
    @PostMapping("/user/LoginSuccess")
    public R loginSuccess(HttpSession session, HttpServletResponse response){
        SpringSecurityUser user = MyuserDetailsService.user;
        session.setAttribute("user",user);

        R r = new R();
        r.setData(user);
        r.setCode(200);
        r.setMsg("登录成功！！！");

       return r;
    }


    /**
     * @Description: 登录失败
     * @Param: 无
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/9
     */
    @PostMapping("/user/loginError")
    public R loginError(){
        R r = new R();
        r.setCode(201);
        r.setMsg("账号密码错误，请重新登录！！！");
        return r;
    }

    /**
     * 查询验证码
     * @author lt
     */
    @GetMapping("/user/getCode")
    public R getCode(){
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
          VerifyCode verifyCode=new VerifyCode(sb.toString());
        return R.ok().setData(verifyCode);
    }

    /**
     * 通过用户id查询个人头像
     * @author lt
     */
    @GetMapping("/user/getHeadImage")
    public R getHeadImage(User user){
        return userImagesService.selectByUserId(user);
    }


    /**
     * 修改个人头像
     * @author lt
     */
    @PostMapping("/user/updateHeadImage")
    public R updateHeadImage(@RequestParam("fileName") MultipartFile file, User user){
        return userImagesService.updateHeadImage(file, user);
    }


    /**
     * @Description: 查询个人信息
     * @Param: number 个人信息
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/9
     */
    @GetMapping("/user/getUser")
    public R getUser(String number){
        User user = userService.getUserByNumber(number);
        user.setPasswd(null);
        return R.ok().setData(user);
    }


    /**
     * @Description: 修改密码操作
     * @Param: newPasswd 新的密码
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/9
     */
    @PutMapping("/user/updatePw")
    public R getUser(@RequestParam("oldPasswd") String oldPasswd,
                     @RequestParam("newPasswd") String newPasswd,
                     @RequestParam("number") String number){

       R r = userService.udpatePasswordByNumber(oldPasswd,number,newPasswd);
        return r;
    }


    /**
     * @Description: 查询学院列表
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/9
     *
     *
     * 思路：如果要查询学院下的专业，需要将学院名字传递过来
     *      如果查询学院下的教研室，需要将学院的名字查询过来
     *      如果查询部门下的科室，则传进来部门的id
     */
    @GetMapping("/user/getCollegeList")
    public R getCollegeList(@RequestParam("faculty") String faculty,
                            @RequestParam(value = "condition",required = false) String condition){

        R r = organizationService.queryByCommonAndCondition(faculty,condition);
        r.setCode(200);
        r.setMsg("查询成功！");
        return r;
    }


    /**
     * @Description: 查询课程名
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/22
     * 根据学院，专业，年级，学期，层次查询课程名
     */
    @GetMapping("/user/getCourseInformation")
    public R getCouseInfo(Courseinformation courseinformation){

        R r = courseInformationService.queryByInfo(courseinformation);
        return r;
    }


}
