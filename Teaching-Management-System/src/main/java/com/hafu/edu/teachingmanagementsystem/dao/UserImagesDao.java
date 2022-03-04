package com.hafu.edu.teachingmanagementsystem.dao;

import com.hafu.edu.teachingmanagementsystem.entity.User;
import com.hafu.edu.teachingmanagementsystem.entity.UserImages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (UserImages)表数据库访问层
 *
 * @author makejava
 * @since 2022-02-06 17:47:15
 */
public interface UserImagesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param useId 主键
     * @return 实例对象
     */
    UserImages queryById(Long useId);

    /**
     * 查询指定行数据
     *
     * @param userImages 查询条件
     * @param pageable   分页对象
     * @return 对象列表
     */
    List<UserImages> queryAllByLimit(UserImages userImages, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param userImages 查询条件
     * @return 总行数
     */
    long count(UserImages userImages);

    /**
     * 新增数据
     *
     * @param userImages 实例对象
     * @return 影响行数
     */
    int insert(UserImages userImages);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserImages> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserImages> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserImages> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserImages> entities);

    /**
     * 修改数据
     *
     * @param userImages 实例对象
     * @return 影响行数
     */
    int update(UserImages userImages);

    /**
     * 通过主键删除数据
     *
     * @param useId 主键
     * @return 影响行数
     */
    int deleteById(Long useId);

    /**
     * 通过用户id查询个人头像
     * @author lt
     */
    UserImages selectByUserId(Long uid);


    /**
     * 通过用户id修改头像
     * @author lt
     */
    int updateHeadImage(UserImages userImages);
}

