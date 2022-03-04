package com.hafu.edu.teachingmanagementsystem.service;

import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-02-06 17:46:53
 */

public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    User queryById(Long uid);

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<User> queryByPage(User user, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);


    /**
     * @Description: 管理修改用户信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/11
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    boolean deleteById(Long uid);


    /**
     * 通过账号查询整个对象
     * @param number 账号
     * @return user对象
     */
    User getUserByNumber(String number);


    /**
     * 通过number修改账号密码
     * @param number 学号或者工号
     * @param newPasswd 新的密码
     * @return int
     */
    R udpatePasswordByNumber(String oldPasswd,String number, String newPasswd);

    /**
     * @Description: 通过名字查询账号信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/11
     * 
     * 2022/02/17 废除，改成下面
     */
    R queryUserByUserName(String username);

    /**
     * 管理员查询多个用户
     * 2022/2/11
     * @author lt
     */
    R getAllUsers(int pageNum,int pageSize,User user);

    /**
     * 管理员添加一个用户信息
     * 2022/2/13
     * @author lt
     */
     R addUser(User user);

     /**
      * @Description: 管理员批量添加用户信息
      * @Param: 
      * @return: 
      * @Author: 程世玉
      * @Date: 2022/2/14
      */
    R batchAddAllUser(List<User> userList);

    /**
     * @Description: 管理员修改用户信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/14
     */
    R updateUserByAdmin(User user);

    /**
     * @Description: 根据用户名批量查询用户信息
     * @Param: 
     * @return: 
     * @Author: 程世玉
     * @Date: 2022/2/17
     */
    R queryUserByUserNameList(List<String> usernameList);
}
