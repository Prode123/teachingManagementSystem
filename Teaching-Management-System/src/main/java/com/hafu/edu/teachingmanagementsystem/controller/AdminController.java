package com.hafu.edu.teachingmanagementsystem.controller;

import com.hafu.edu.teachingmanagementsystem.Utils.POIUserUtils;
import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.entity.User;
import com.hafu.edu.teachingmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * @author 程世玉
 * @create 2022/2/8 12:47
 * @PROJECT_NAME Teaching-Management-System
 * @Description  管理员控制层
 *                 1、管理员查询多个用户                 getAllUsers
 *  *              2、管理员修改用户信息                 updateUser
 *  *              3、管理员添加用户                    addUser
 *  *              4、超级管理员添加管理员               addPowerUser
 *                 5、管理员删除用户信息                 deleteUser
 *                 6、更改配色                         updateColor
 *                 7、批量导入用户信息                  batchAddUsers
 */
@RestController
@CrossOrigin
//@PreAuthorize("hasRole('ROLE_4')")//管理员身份才可以访问
public class AdminController {

    @Autowired
    private UserService userService;


    /**
     * @Description: 管理员修改用户信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/11
     */
    @PutMapping("/admin/updateUser")
    public R updateUser(User user) {

        R flag = userService.updateUserByAdmin(user);

        return flag;
    }


    /**
     * @Description: 管理员删除用户信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/14
     */
    @DeleteMapping("/admin/deleteUser")
    public R deleteUser(@RequestParam("uid") Long uid) {
        boolean b = userService.deleteById(uid);

        if (b) {
            return R.ok();
        }

        return R.exp(201, "删除用户失败");
    }

    /**
     * @Description: 管理员批量导入用户信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/13
     */
    @PostMapping("/admin/batchAddUsers")
    public R batchAddUsers(@RequestParam("excelFile") MultipartFile excelFile) {

        List<User> userList = POIUserUtils.getUserList(excelFile);
        if (userList.size() == 0){
            return R.exp(201,"抱歉，excel信息读取失败，请查看excel表格是否存在数据");
        }
        System.out.println(userList.size());
        for (User user : userList) {
            System.out.println("Controller = " + user);
        }

        R r = userService.batchAddAllUser(userList);
        return r;
    }

    /**
     * 管理员查询多个用户
     * 2022/2/12
     * @author lt
     */
    @GetMapping("/admin/getAllUsers")
    public R getAllUsers(int pageNum,int pageSize,User user){
      return userService.getAllUsers(pageNum,pageSize,user);
    }


    /**
     * 管理员添加一个用户信息
     * 2022/2/13
     * @author lt
     */
    @PostMapping("admin/addUser")
    public R addUser(User user){

        return userService.addUser(user);
    }

    /**
     * @Description: 超级管理员添加管理员信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/13
     */
    @PostMapping("/admin/addPowerUser")
    public R addPowerUser(User user){
        return userService.addUser(user);
    }


    /**
     * @Description: 更换配色
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/13
     * 如果返回1，则是经典款，如果是2，则是红色 如果是3，则是灰色
     */
    @PutMapping("/admin/updateColor")
    public R updateColor(Integer colorId){
        return R.ok().setData(colorId);
    }




//    @GetMapping("/user/updateColor")
//    public R userColor(){
//        return R.ok().setData(colorId);
//    }



}
