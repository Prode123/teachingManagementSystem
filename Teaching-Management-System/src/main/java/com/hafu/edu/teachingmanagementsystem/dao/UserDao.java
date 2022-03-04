package com.hafu.edu.teachingmanagementsystem.dao;

import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2022-02-06 17:46:53
 */
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    User queryById(Long uid);

    /**
     * 查询指定行数据
     *
     * @param user     查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<User> queryAllByLimit(User user, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param user 查询条件
     * @return 总行数
     */
    long count(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<User> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<User> entities);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 影响行数
     */
    int deleteById(Long uid);

    /**
     * 通过账号查询user对象
     * @param number 账号
     * @return user对象
     */
    User queryByNumber(String number);

    /**
     * @Description: 通过账号修改密码
     * @Param: number
     * @return: encode
     * @Author: 程世玉
     * @Date: 2022/2/11
     */
    int updatePwByNumber(@Param("number") String number,@Param("passwd") String encodePassword);


    /**
     * @Description: 通过账号获取用户信息
     * @Param:
     * @return: list、
     * @Author: 程世玉
     * @Date: 2022/2/11
     */
    ArrayList<User> queryByUserName(String username);

    /**
     * 管理员查询所有符合条件的老师
     * 2022/2/12
     * @author lt
     */
    ArrayList<User> selectAllTeacher(User user);

    /**
     * 管理员查询所有符合条件的学生
     * 2022/2/12
     * @author lt
     */
    List<User> selectAllStudent(User user);



}

